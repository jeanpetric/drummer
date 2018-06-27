/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tab;

import engine.Bar;
import engine.Bars;
import engine.MiniBar;

/**
 *
 * @author Jean Petric
 */
public class TabReader {
    private final int SHORT_BAR_DESCRIPTION_LENGTH = 2;
    private final Bars bars;
    private final int measureLeft;
    private final int measureRight;

    public TabReader(TabLoader tabLoader, int measureLeft, int measureRight) {
        bars = new Bars();
        this.measureLeft = measureLeft;
        this.measureRight = measureRight;
        String line;

        int barLine = 0;
        while ((line = tabLoader.nextLine()) != null) {
            if (line.equals("\n") || line.trim().equals("")) {
                barLine = 0;
                continue;
            }
            String lineDrum = line.substring(0, SHORT_BAR_DESCRIPTION_LENGTH-1);
            Bar currentBar = getBarForLine(barLine, lineDrum);
            bars.add(currentBar);
            visit(line, currentBar);
            barLine++;
        }
    }
    
    /**
     * Return the whole track with all Bar and MiniBar.
     * @return Bars
     */
    public Bars getBars() {
        return bars;
    }

    private Bar getBarForLine(int barLine, String barDesc) {
        Bar mb = bars.get(barLine);
        if (mb == null) {
            mb = new Bar(barDesc, measureLeft, measureRight);
        }
        return mb;
    }
    
    private void visit(String line, Bar barForLine) {
        String notes = line.substring(SHORT_BAR_DESCRIPTION_LENGTH);
        for (int i = 0; i < notes.length(); i++) {
            char currentChar = line.charAt(i);
            if (currentChar == '|') {
                continue;
            }
            MiniBar miniBar = new MiniBar();
            miniBar.add(String.valueOf(currentChar));
            barForLine.addMiniBar(miniBar);
        }
    }
}
