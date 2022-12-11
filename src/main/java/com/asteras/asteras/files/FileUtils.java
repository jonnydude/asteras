package com.asteras.asteras.files;

import static com.asteras.asteras.files.PublicationFields.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author ipitr
 */
public class FileUtils {

    private static final String END_WITH_ANGLE_BRACKET_COMMA = "},";
    private static final String END_WITH_ANGLE_BRACKET = "}";
    private static final String START_WITH = "{";
     private static final String ΑΤ = "@";
    

    public static List<Researcher> getInitialData() throws URISyntaxException, IOException {
        List<Researcher> researcherList = new ArrayList<>();

        for (File file : getResourceFolderFiles("dit-uop-professors")) {
            System.out.println(file);
            try ( BufferedReader br = Files.newBufferedReader(file.toPath())) {
                String li = null;
                boolean start = false;
                Researcher researcher = new Researcher(file.getName());
                StringBuilder currentRow = null;
                String currentKey = null;
                Publication pub = null;

                while ((li = br.readLine()) != null) {
                    String line = li.trim();
                    System.out.println("line : " + line);
                    if (line.startsWith(ΑΤ)) {
                        start = true;
                        pub = new Publication();
                    } else if (line.equals(END_WITH_ANGLE_BRACKET)) {
                        start = false;
                        researcher.getPublications().add(pub);
                    } else if (start) {
                        String[] parts = line.split("=");
                        if (parts.length == 2) {
                            currentKey = parts[0].trim();
                            String trimmed = parts[1].trim();
                            String value = getText(trimmed);
                            if (!trimmed.endsWith(END_WITH_ANGLE_BRACKET_COMMA) && !trimmed.endsWith(END_WITH_ANGLE_BRACKET)) {
                                currentRow = new StringBuilder();
                                currentRow.append(value);
                            } else {
//                            researcher.getPublications().put(currentKey, value);
//                                System.out.println("key= " + currentKey + "   value = " + value);
                                setField(pub, currentKey, value);
                            }
                        } else {
                            String trimmed = parts[0].trim();
                            String value = getText(trimmed);
                            currentRow.append(value);
                            if (trimmed.endsWith(END_WITH_ANGLE_BRACKET_COMMA)) {
//                            researcher.getPublications().put(currentKey, currentRow.toString());
//                                System.out.println("key= " + currentKey + "   value = " + currentRow.toString());
                                setField(pub, currentKey, currentRow.toString());
                            }
                        }
                    }
                }
//                System.out.println("\n" + researcher.toString());
                researcherList.add(researcher);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return researcherList;
    }
   

    private static void setField(Publication publication, String field, String value) {
        switch (field) {
            case AUTHOR:
                publication.setAuthor(value);
                break;
            case TITLE:
                publication.setTitle(value);
                break;
            case BOOKTITLE:
                publication.setBooktitle(value);
                break;
            case JOURNAL:
                publication.setJournal(value);
                break;
            case VOLUME:
                publication.setVolume(value);
                break;
            case NUMBER:
                publication.setNumber(value);
                break;
            case PAGES:
                publication.setPages(value);
                break;
            case PUBLISHER:
                publication.setPublisher(value);
                break;
            case YEAR:
                publication.setYear(value);
                break;
            case URL:
                publication.setUrl(value);
                break;
            case DOI:
                publication.setDoi(value);
                break;
            case TIMESTAMP:
                publication.setTimestamp(value);
                break;
            case BIBURL:
                publication.setBiburl(value);
                break;
            case BIBSOURCE:
                publication.setBibsource(value);
                break;
            default:
                throw new AssertionError();
        }
    }

    private static String getText(String line) {
        return line.startsWith(START_WITH) ? getSubText(line, 1) : getSubText(line, 0);
    }

    private static String getSubText(String line, int startIndex) {
        if (line.endsWith(END_WITH_ANGLE_BRACKET_COMMA)) {
            return line.substring(startIndex, line.length() - 2);
        } else if (line.endsWith(END_WITH_ANGLE_BRACKET)) {
            return line.substring(startIndex, line.length() - 1);
        } else {
            return startIndex > 0 ? line.substring(startIndex) : line;
        }
    }
    

    private static File[] getResourceFolderFiles(String folder) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource(folder);
        String path = url.getPath();
        return new File(path).listFiles();
    }

}
