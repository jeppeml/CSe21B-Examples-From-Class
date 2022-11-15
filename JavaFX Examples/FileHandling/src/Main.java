import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String MOVIE_SOURCE = "data/movie_titles.txt";
    private static final String fileName = "src/test.txt";
    public static void main(String[] args) throws IOException {
        //printFileContents(fileName);
        //addToFile(fileName, "Rhello!");
        //printFileContents(fileName);
        printFileWithNIO(fileName);
        Main m = new Main();
        Movie movie = m.getMovie(2);
        System.out.println(m);
    }

    private Movie getMovie(int id) {
        try {
            List<String> lines = Files.readAllLines(Path.of(MOVIE_SOURCE));
            for(String line : lines ){
                Movie currentMovie = stringArrayToMovie(line);
                if(currentMovie.getId() == id){
                    return currentMovie;
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Movie stringArrayToMovie(String t) {
        String[] arrMovie = t.split(",");

        int id = Integer.parseInt(arrMovie[0]);
        int year = Integer.parseInt(arrMovie[1]);
        String title = arrMovie[2];
        if (arrMovie.length > 3) {
            for (int i = 3; i < arrMovie.length; i++) {
                title += "," + arrMovie[i];
            }
        }
        Movie mov = new Movie(id, year, title);
        return mov;
    }

    private static void printFileWithNIO(String fileName){
        try {
            List<String> r = Files.readAllLines(Path.of("Moivetitles.txt"));
            for(String s : r){
                String[] data = s.split(",");
                System.out.println("Name:");
                System.out.println(data[0]);
                System.out.println("CPR");
                System.out.println(data[1]);
                System.out.println("Phone");
                System.out.println(data[2]);
            }
            System.out.println(r);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static void addToFile(String fileName, String text) {
        try(FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw)){

            pw.println(text);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printFileContents(String filename){
        try(FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            Scanner sc = new Scanner(br))
        {
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);
            }
        }
        catch (FileNotFoundException fnf){
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}