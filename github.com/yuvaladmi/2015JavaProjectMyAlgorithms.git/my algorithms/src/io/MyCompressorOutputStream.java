package io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * This class extends OutputStream
 * 
 * @author Yuval Admi & Afek Ben Simon
 *
 */
public class MyCompressorOutputStream extends OutputStream {

    private OutputStream out;
    private int previous;
    private int count;

    /**
     * CTOR
     * 
     * @param out
     */
    public MyCompressorOutputStream(OutputStream out) {
	this.out = out;
	this.previous = -1;
	this.count = 0;
    }

    @Override
    public void write(byte[] b) throws IOException {
	super.write(b);
	write(previous);
	write(count);
    }

    /**
     * Overrides write, gets an int parameter and checks if this parameter
     * equals to the previous one, if they are equal, the method count them,
     * else it prints how many parameters we had before, and starts the counting
     * from the beggining.
     */
    @Override
    public void write(int b) throws IOException {
	if (previous != b) {
	    previous = b;
	    if (count != 0) {
		out.write(count);
		count = 1;
	    } else {
		if (count == 255) {
		    out.write(b);
		    out.write(count);
		    count = 1;
		} else {
		    count++;
		}
	    }
	    out.write(b);

	} else {
	    if (count == 255) {
		out.write(b);
		out.write(count);
		count = 1;
	    } else {
		count++;
	    }
	}
    }
}
