
import java.io.BufferedReader;
import java.io.IOException;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {


  public static void main(final String[] args) {

    Charset charset = Charset.forName("UTF-8");
    Path file =Path.of("mots.txt");
    List<String> list = new ArrayList<>();
    try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
        String line = null;
        while ((line = reader.readLine()) != null) {
            list.add(line);
            
        }
    } catch (IOException x) {
        System.err.format("IOException: %s%n", x);
    }

    

    Map<String,List<String>> map = list.stream().collect(Collectors.groupingBy((mot) -> convert(mot)));
    map.forEach((k,v)-> System.out.println(map.get(k)));
  }

  public static String convert(String text) {
    char[] chars = text.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }
}