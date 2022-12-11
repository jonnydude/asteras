package com.asteras.asteras;

import com.asteras.asteras.files.FileUtils;
import com.asteras.asteras.files.Researcher;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.ByteBuffersDirectory;
import org.apache.lucene.store.Directory;


/**
 *
 * @author ipitr
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            List<Researcher> researcherList = FileUtils.getInitialData();
            for (Researcher researcher : researcherList) {
//                System.out.println(researcher);
                 StandardAnalyzer analyzer = new StandardAnalyzer();
                Directory index = new ByteBuffersDirectory();
                IndexWriterConfig config = new IndexWriterConfig(analyzer);
                IndexWriter w = new IndexWriter(index, config);
            }
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
