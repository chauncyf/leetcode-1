public class Codec {

    HashMap<String, String> url2code = new HashMap<>();
    HashMap<String, String> code2url = new HashMap<>();
    String base = "http://tinyurl.com/";

// encode 
    public String encode(String longurl){
        if(url2code.containsKey(longurl)) return base + url2code.get(longurl);
        String key = generateRandomShortUrl(longurl);
        while(code2url.containsKey(key)){
            key = generateRandomShortUrl(longurl);
        }
        url2code.put(longurl, key);
        code2url.put(key, longurl);
        return base + key;
        
    }

// decode 
    public String decode(String shorturl){
        return code2url.get(shorturl.replace(base,""));
    }

// generate random short url (length = 6) 
    public String generateRandomShortUrl(String longurl){
        String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567809";
        StringBuffer shorturl = new StringBuffer();
        for(int i=0; i<6; i++){
            shorturl.append(charset.charAt((int)(Math.random()*charset.length())));
        }
        return shorturl.toString();
    }
    
}