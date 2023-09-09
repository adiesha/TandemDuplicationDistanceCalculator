package org.msu.adiesha.utils;

import org.biojava.nbio.genome.parsers.genename.GeneChromosomePosition;
import org.biojava.nbio.genome.parsers.genename.GeneChromosomePositionParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenePositions {




    public static void main(String[] args) {
        try {

            List<GeneChromosomePosition> genePositions = GeneChromosomePositionParser.getChromosomeMappings();
            System.out.println("got " + genePositions.size() + " gene positions");

            for (GeneChromosomePosition pos : genePositions) {
                if (pos.getGeneName().equals("FOLH1")) {
                    System.out.println(pos);
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
