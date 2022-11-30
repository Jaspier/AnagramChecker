package AnagramChecker.cache;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileWR {

    final static String path = "/Users/allendungo/Work/AnagramChecker/src/main/resources/cache.txt";

    private final Logger logger = Logger.getLogger(this.getClass());

    private File file = new File(path);
    private Map<String, String> cache = new HashMap<>();

    public FileWR(){
    }

    public void CacheHandler(Map<String, String> values){
        createCacheIfNotExists(file);
        ReadStoredCacheAndPopulateLocalInstance(file, cache);
        AppendUniqueValuesToStoredCache(values, file, cache);
    }

    private void AppendUniqueValuesToStoredCache(Map<String, String> values, File file, Map<String, String> cache) {
        try{
            BufferedWriter bf = new BufferedWriter(new FileWriter(file, true));
            for(Map.Entry<String, String> entry: values.entrySet()){
                if(!cache.containsKey(entry.getKey())){
                    bf.write(entry.getKey() + "-" + entry.getValue());
                    bf.newLine();
                }
            }
            bf.flush();

        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Failed to write to cache", e);
        }
    }

    private void ReadStoredCacheAndPopulateLocalInstance(File file, Map<String, String> cache) {
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                String[] cachedValues = line.split("-");
                String key = cachedValues[0].trim();
                String username = cachedValues[1].trim();

                if(!key.equals("") && !username.equals("")){
                    cache.put(key, username);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Failed to read or populate cache", e);
        }
    }

    private void createCacheIfNotExists(File file) {
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Failed to create cache", e);
        }
    }


    public Map<String, String> getMapFromCache(){
        createCacheIfNotExists(file);
        ReadStoredCacheAndPopulateLocalInstance(file, cache);
        return cache;
    }
}
