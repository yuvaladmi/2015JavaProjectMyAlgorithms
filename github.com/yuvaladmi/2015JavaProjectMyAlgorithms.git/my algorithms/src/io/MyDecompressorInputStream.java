package io;

import java.io.IOException;
import java.io.InputStream;

/**
 * This class extends InputStream
 * 
 * @author Yuval Admi & Afek Ben Simon
 *
 */
public class MyDecompressorInputStream extends InputStream {

    private InputStream in;
    private int count;
    private int lastByte;

    /**
     * CTOR
     * 
     * @param in
     * @param count
     */
    public MyDecompressorInputStream(InputStream in) {
	this.in = in;
	this.count = 1;
    }

    /**
     * Override read, gets an int, checks if we had this number before,
     * otherwise, reads the last byte and how many times we should write it
     */
    @Override
    public int read() throws IOException {
	if (count > 1) {
	    count--;
	    return lastByte;
	}
	lastByte = in.read();
	count = in.read();
	return lastByte;
    }

}
