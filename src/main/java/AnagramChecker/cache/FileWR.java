package AnagramChecker.cache;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileWR {

    private File file = new File("cache.txt");
    private Map<String, String> cache = new HashMap<String, String>();

    public FileWR(){
    }

    public void CacheHandler(Map<String, String> values){
        createCacheIfNotExists(file);
        ReadCacheAndUpdate(file, cache);
        AppendUniqueKeyValueToCache(values, file, cache);
    }

    private static void AppendUniqueKeyValueToCache(Map<String, String> values, File file, Map<String, String> cache) {
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
        }
    }

    private static void ReadCacheAndUpdate(File file, Map<String, String> cache) {
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
        }
    }

    private static void createCacheIfNotExists(File file) {
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Map<String, String> getMapFromCache(){

        createCacheIfNotExists(file);

        ReadCacheAndUpdate(file, cache);

        return cache;
    }
}
