package boot;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class Run {

    public static void main(String[] args) throws IOException {
	Maze3d maze = (new MyMaze3dGenerator(3, 5, 9)).generate(3, 5,9); // ...
									  // generate
									  // it
	// save it to a file
	OutputStream out = new MyCompressorOutputStream(new FileOutputStream("1.maz"));
	out.write(maze.toByteArray());
	out.flush();
	out.close();
	InputStream in = new MyDecompressorInputStream(new FileInputStream("1.maz"));
	byte b[] = new byte[maze.toByteArray().length];
	in.read(b);
	in.close();
	Maze3d loaded = new Maze3d(b);
	loaded.print();
	System.out.println(loaded.equals(maze));

    }

}
