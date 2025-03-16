public class Codec {

    private final String baseUrl = "http://tinyurl.com/";
    private final Map<String, String> map = new HashMap<>();
    private final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final Random rand = new Random();
    private final int keyLenth = 6;


    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key;
        do{
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < keyLenth; i++) {
                sb.append(characters.charAt(rand.nextInt(characters.length())));
            }
            key = sb.toString();
        } while(map.containsKey(key) && !map.get(key).equals(longUrl));
        map.put(key, longUrl);
        return baseUrl + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace(baseUrl, "");
        return map.get(key);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));