package com.aavash.dataFetch.Model;

public class GlobalData {
    private Long recovered;

    private Long cases;

    private Long deaths;

    public Long getRecovered() {
        return recovered;
    }

    public void setRecovered(Long recovered) {
        this.recovered = recovered;
    }

    public Long getCases() {
        return cases;
    }

    public void setCases(Long cases) {
        this.cases = cases;
    }

    public Long getDeaths() {
        return deaths;
    }

    public void setDeaths(Long deaths) {
        this.deaths = deaths;
    }

    @Override
    public String toString() {
        return "GlobalData{" +
                "recovered=" + recovered +
                ", cases=" + cases +
                ", deaths=" + deaths +
                '}';
    }
}
