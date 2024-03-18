package org.msu.adiesha.test.finaltests;

import org.msu.adiesha.MaximalIncreasingSubstrings;
import org.msu.adiesha.utils.ReadMTGeneOrder;
import org.msu.adiesha.utils.Utils;

import java.util.List;
import java.util.Map;

public class TestAgainstVertebrate {
    public static void main(String[] args) {
        /*
         * Convergence 11 (Boulengerula taitana, Clinocottus analis)
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Cottidae/Clinocottus_analis/Clinocottus_analis_final.txt", "Clinocottus_analis");
        DoTestAgainstVertebrate("data/mitochondrialdna/Herpelidae/Boulengerula_taitana/Boulengerula_taitana_final_final.txt", "Boulengerula_taitana");

        /*
         * Convergence 10 (Lampris guttatus, Hapalogenys analis, Trichiurus japonicus)
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Lampridae/Lampris_guttatus/Lampris_guttatus_final.txt", "Lampris_guttatus");
        DoTestAgainstVertebrate("data/mitochondrialdna/Hapalogenyidae/Hapalogenys_analis/Hapalogenys_analis_final.txt", "Hapalogenys_analis");
        DoTestAgainstVertebrate("data/mitochondrialdna/Trichiuridae/Trichiurus_japonicus/Trichiurus_japonicus_final.txt", "Trichiurus_japonicus");


        /*
         * Convergence 9
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Monacanthidae/Rudarius_ercodes/Rudarius_ercodes_final.txt", "Rudarius_ercodes");
        DoTestAgainstVertebrate("data/mitochondrialdna/Umbridae/Dallia_pectoralis/Dallia_pectoralis_final.txt", "Dallia_pectoralis");

        /*
         * Convergence 8 (
         */

        DoTestAgainstVertebrate("data/mitochondrialdna/Platytroctidae/Normichthys_operosus/Normichthys_operosus_final.txt", "Normichthys_operosus");
        DoTestAgainstVertebrate("data/mitochondrialdna/Ambassidae/Ambassis_gymnocephalus/Ambassis_gymnocephalus_final.txt", "Ambassis_gymnocephalus");


        /*
         * Convergence 7
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Aulorhynchidae/Aulorhynchus_flavidus/Aulorhynchus_flavidus_final.txt", "Aulorhynchus_flavidus");


        /*
         * Convergence 6
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Macrouridae/Trachyrincus_murrayi/Trachyrincus_murrayi_final.txt", "Trachyrincus_murrayi");
        DoTestAgainstVertebrate("data/mitochondrialdna/Macrouridae/Squalogadus_modificatus/Squalogadus_modificatus_final.txt", "Squalogadus_modificatus");


        /*
         * Convergence 5
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Macrouridae/Cetonurus_globiceps/Cetonurus_globiceps_final.txt", "Cetonurus_globiceps");
        DoTestAgainstVertebrate("data/mitochondrialdna/Macrouridae/Coelorinchus_kishinouyei/Coelorinchus_kishinouyei_final.txt", "Coelorinchus_kishinouyei");
        DoTestAgainstVertebrate("data/mitochondrialdna/Macrouridae/Ventrifossa_garmani/Ventrifossa_garmani_final.txt", "Ventrifossa_garmani");
        DoTestAgainstVertebrate("data/mitochondrialdna/Gekkonidae/Uroplatus_fimbriatus/Uroplatus_fimbriatus_final.txt", "Uroplatus_fimbriatus");


        /*
         * Convergence 4
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Kurtidae/Kurtus_gulliveri/Kurtus_gulliveri_final.txt", "Kurtus_gulliveri");
        DoTestAgainstVertebrate("data/mitochondrialdna/Benthophilinae/Ponticola_kessleri/Ponticola_kessleri_final.txt", "Ponticola_kessleri");
        DoTestAgainstVertebrate("data/mitochondrialdna/Chamaeleonidae/Chamaeleo_arabicus/Chamaeleo_arabicus_final.txt", "Chamaeleo_arabicus");
        DoTestAgainstVertebrate("data/mitochondrialdna/Agamidae/Xenagama_taylori/Xenagama_taylori_final_final.txt", "Xenagama_taylori_final");
        DoTestAgainstVertebrate("data/mitochondrialdna/Agamidae/Uromastyx_benti/Uromastyx_benti_final.txt", "Uromastyx_benti");
        DoTestAgainstVertebrate("data/mitochondrialdna/Agamidae/Phrynocephalus_putjatai/Phrynocephalus_putjatai_final.txt", "Phrynocephalus_putjatai");



        /*
         * Convergence 3
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Nototheniidae/Pagothenia-borchgrevinki/Pagothenia-borchgrevinki_final.txt", "Pagothenia-borchgrevinki");
        DoTestAgainstVertebrate("data/mitochondrialdna/Rhineuridae/Rhineura_floridana/Rhineura_floridana_final_final.txt", "Rhineura_floridana_final");


        /*
         * Convergence 2
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Derichthyidae/Coloconger_cadenati/Coloconger_cadenati_final.txt", "Coloconger_cadenati");
        DoTestAgainstVertebrate("data/mitochondrialdna/Congridae/Ariosoma_shiroanago/Ariosoma_shiroanago_final.txt", "Ariosoma_shiroanago");
        DoTestAgainstVertebrate("data/mitochondrialdna/Congridae/Paraconger_notialis/Paraconger_notialis_final.txt", "Paraconger_notialis");
        DoTestAgainstVertebrate("data/mitochondrialdna/Congridae/Conger_japonicus/Conger_japonicus_final.txt", "Conger_japonicus");
        DoTestAgainstVertebrate("data/mitochondrialdna/Congridae/Heteroconger_hassi/Heteroconger_hassi_final.txt", "Heteroconger_hassi");
        DoTestAgainstVertebrate("data/mitochondrialdna/Derichthyidae/Derichthys_serpentinus/Derichthys_serpentinus_final.txt", "Derichthys_serpentinus");
        DoTestAgainstVertebrate("data/mitochondrialdna/Derichthyidae/Nessorhamphus_ingolfianus/Nessorhamphus_ingolfianus_final.txt", "Nessorhamphus_ingolfianus");
        DoTestAgainstVertebrate("data/mitochondrialdna/Muraenesocidae/Cynoponticus_ferox/Cynoponticus_ferox_final.txt", "Cynoponticus_ferox");
        DoTestAgainstVertebrate("data/mitochondrialdna/Muraenesox_bagio/Muraenesox_bagio.txt", "Muraenesox");
        DoTestAgainstVertebrate("data/mitochondrialdna/Nettastomatidae/Facciolella_oxyrhyncha/Facciolella_oxyrhyncha_final.txt", "Facciolella_oxyrhyncha");
        DoTestAgainstVertebrate("data/mitochondrialdna/Nettastomatidae/Hoplunnis_punctata/Hoplunnis_punctata_final.txt", "Hoplunnis_punctata");
        DoTestAgainstVertebrate("data/mitochondrialdna/Nettastomatidae/Nettastoma_parviceps/Nettastoma_parviceps_final.txt", "Nettastoma_parviceps");
        DoTestAgainstVertebrate("data/mitochondrialdna/Ophichthidae/Ophisurus_macrorhynchos/Ophisurus_macrorhynchos_final.txt", "Ophisurus_macrorhynchos");
        DoTestAgainstVertebrate("data/mitochondrialdna/Channichthyidae/Chaenocephalus_aceratus/Chaenocephalus_aceratus_final.txt", "Chaenocephalus_aceratus");
        DoTestAgainstVertebrate("data/mitochondrialdna/Channichthyidae/Chionodraco_hamatus/Chionodraco_hamatus_final.txt", "Chionodraco_hamatus");

        DoTestAgainstVertebrate("data/mitochondrialdna/Nototheniidae/Notothenia_coriiceps/Notothenia_coriiceps_final.txt", "Notothenia_coriiceps");
        DoTestAgainstVertebrate("data/mitochondrialdna/Plethodontidae/Aneides_flavipunctatus/Aneides_flavipunctatus_final.txt", "Aneides_flavipunctatus");
        DoTestAgainstVertebrate("data/mitochondrialdna/Plethodontidae/Stereochilus_marginatus/Stereochilus_marginatus_final_final.txt", "Stereochilus_marginatus_final");

        /*
         * Convergence 1
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Siphonopidae/Siphonops_annulatus/Siphonops_annulatus_final_final.txt", "Siphonops_annulatus_final");
    }

    public static void DoTestAgainstVertebrate(String pathOfTheTarget, String name) {
        System.out.println("+_+_+_+_+_+_+_+_+_+_+_");

        List<String> geneOrder_vertebrate = ReadMTGeneOrder.readGeneOrderFromCustomFiles("data/" +
                "mitochondrialdna/vertibrate_final.txt");
        List<String> geneOrder_target = ReadMTGeneOrder.readGeneOrderFromCustomFiles(pathOfTheTarget);
        Map<String, Character> out;
        out = ReadMTGeneOrder.assignCharsToStringList(geneOrder_vertebrate);
//        System.out.println(ReadMTGeneOrder.getTheChangedOutput(geneOrder_sym_ori, out));
        System.out.println("Source: " + name);
        String str1 = ReadMTGeneOrder.getTheChangedOutput(geneOrder_vertebrate, out);
        String str2 = ReadMTGeneOrder.getTheChangedOutput(geneOrder_target, out);
        System.out.println(str1);
        System.out.println(str2);

        List<List<MaximalIncreasingSubstrings.Result>> result = MaximalIncreasingSubstrings.
                findMaximalIncreasingSubsequences(str1, str2);
        Utils.printMaximalIncreasingSubsequenceResults(result, str2);
        System.out.println("MIS#: " + result.size());
        System.out.println("Number of TDs = log_2(\\rho_S(T))= " + (int) Math.ceil(Utils.log_2(result.size())));

        int count = (int) Math.ceil(Utils.log_2(result.size()));
        List<MaximalIncreasingSubstrings.Result> deletionResult = MaximalIncreasingSubstrings.
                findLZPhrases(str1.repeat((int) Math.pow(2, count)), str2);
        int deletions = deletionResult.size() + 1;
        System.out.println("Deletions: " + deletions);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        Utils.ResultSet resultSet = new Utils.ResultSet();
        resultSet.noOfmis = result.size();
        resultSet.deletions = deletions;
        resultSet.tds = count;
        resultSet.sourceName = name;
        resultSet.targetName = "vertibrate";
        Utils.writeResultsToFile(resultSet, "data/result/vertibratevsothers.txt");
        // ----------------------------------------------------------------------------
        // do the reverse
        System.out.println("***************************************");
        out = ReadMTGeneOrder.assignCharsToStringList(geneOrder_target);
        str1 = ReadMTGeneOrder.getTheChangedOutput(geneOrder_target, out);
        str2 = ReadMTGeneOrder.getTheChangedOutput(geneOrder_vertebrate, out);
        System.out.println("Source: " + name);
        if (str2 == null) {
            System.out.println("str1 does not contain all the characters in the str2");
            return;
        }
        System.out.println(str1);
        System.out.println(str2);
        result = MaximalIncreasingSubstrings.
                 findMaximalIncreasingSubsequences(str1, str2);
        Utils.printMaximalIncreasingSubsequenceResults(result, str2);

        System.out.println("MIS#: " + result.size());
        System.out.println("Number of TDs = log_2(\\rho_S(T))= " + (int) Math.ceil(Utils.log_2(result.size())));

        count = (int) Math.ceil(Utils.log_2(result.size()));
        deletionResult = MaximalIncreasingSubstrings.
                findLZPhrases(str1.repeat((int) Math.pow(2, count)), str2);
        deletions = deletionResult.size() + 1;
        System.out.println("Deletions: " + deletions);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        resultSet = new Utils.ResultSet();
        resultSet.noOfmis = result.size();
        resultSet.deletions = deletions;
        resultSet.tds = count;
        resultSet.sourceName = "vertibrate";
        resultSet.targetName = name;
        Utils.writeResultsToFile(resultSet, "data/result/othersvsvertibrate.txt");

    }


}
