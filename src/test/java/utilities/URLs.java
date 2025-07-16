package utilities;

public enum URLs {
    BASE_URL("https://www.trendyol.com/");



    private final String url;

    URLs(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url;
    }
} 