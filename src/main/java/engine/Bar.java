/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jean Petric
 */
public class Bar {
    private List<MiniBar> miniBars;
    private final int measureLeft;
    private final int measureRight;
    private final String barDrum;
    private final int distance;
    
    /**
     * 
     * @param barDrum Provide short name to describe which drum this is
     * (e.g. snare, tom, bass, etc.)
     * @param measureLeft e.g. 4
     * @param measureRight e.g. 4
     */
    public Bar(String barDrum, int measureLeft, int measureRight) {
        this.barDrum = barDrum;
        this.measureLeft = measureLeft;
        this.measureRight = measureRight;
        this.distance = measureLeft * measureRight - 1;
    }
    
    private int getStartIndexForPage(int page) {
        int startIndex = 0;
        if (page > 0) {
            startIndex = page * distance + 1;
        }
        return startIndex;
    }
    
    private int getEndIndexForPage(int page) {
        int endIndex = distance;
        if (page > 0) {
            endIndex = getStartIndexForPage(page) + distance;
        }
        return endIndex;
    }
    
    /**
     * Return notes from the chosen Bar page taking into account the measure.
     * @param page
     * @return List of MiniBar for the chosen page
     */
    public List<MiniBar> getMiniBarsFromBarPage(int page) {
        List<MiniBar> result = new ArrayList<>();
        int startIndex = getStartIndexForPage(page);
        int endIndex = getEndIndexForPage(page);
        for (int i = startIndex; i < endIndex; i++) {
            result.add(miniBars.get(i));
        }
        return result;
    }
    
    public List<MiniBar> getMiniBarForBar() {
        return miniBars;
    }
    
    public void replicateMiniBarsFromPageToEnd(int page) {
        List<MiniBar> mb = new ArrayList<>(getMiniBarsFromBarPage(page));
        miniBars.addAll(mb);
    }

    /**
     * Get the short description of the Bar (e.g. Cx for snare)
     * @return 
     */
    public String getBarDrumShortName() {
        return barDrum;
    }
    
    public void addMiniBar(MiniBar miniBar) {
        miniBars.add(miniBar);
    }
}
