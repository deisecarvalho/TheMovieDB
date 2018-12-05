package com.amorim.deise.themoviedb;

import java.util.List;

public class DiscoverData {
    public List<DiscoverDataDetails> results;

    public List<DiscoverDataDetails> getList(){return results;}
    public void setList(List<DiscoverDataDetails> results){this.results = results;}
}
