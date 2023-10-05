package org.msu.adiesha;

import org.msu.adiesha.utils.ReadMTGeneOrder;

import java.util.List;
import java.util.Map;

public class TestAgainstVertebrate {


    public static void main(String[] args) {
        /*
         * Convergence 11 (Boulengerula taitana, Clinocottus analis)
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Cottidae/Clinocottus_analis/Clinocottus_analis_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Herpelidae/Boulengerula_taitana/Boulengerula_taitana_final_final.txt");

        /*
         * Convergence 10 (Lampris guttatus, Hapalogenys analis, Trichiurus japonicus)
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Lampridae/Lampris_guttatus/Lampris_guttatus_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Hapalogenyidae/Hapalogenys_analis/Hapalogenys_analis_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Trichiuridae/Trichiurus_japonicus/Trichiurus_japonicus_final.txt");


        /*
         * Convergence 9
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Monacanthidae/Rudarius_ercodes/Rudarius_ercodes_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Umbridae/Dallia_pectoralis/Dallia_pectoralis_final.txt");

        /*
         * Convergence 8 (
         */

        DoTestAgainstVertebrate("data/mitochondrialdna/Platytroctidae/Normichthys_operosus/Normichthys_operosus_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Ambassidae/Ambassis_gymnocephalus/Ambassis_gymnocephalus_final.txt");


        /*
         * Convergence 7
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Aulorhynchidae/Aulorhynchus_flavidus/Aulorhynchus_flavidus_final.txt");


        /*
         * Convergence 6
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Macrouridae/Trachyrincus_murrayi/Trachyrincus_murrayi_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Macrouridae/Squalogadus_modificatus/Squalogadus_modificatus_final.txt");


        /*
         * Convergence 5
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Macrouridae/Cetonurus_globiceps/Cetonurus_globiceps_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Macrouridae/Coelorinchus_kishinouyei/Coelorinchus_kishinouyei_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Macrouridae/Ventrifossa_garmani/Ventrifossa_garmani_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Gekkonidae/Uroplatus_fimbriatus/Uroplatus_fimbriatus_final.txt");


        /*
         * Convergence 4
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Kurtidae/Kurtus_gulliveri/Kurtus_gulliveri_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Benthophilinae/Ponticola_kessleri/Ponticola_kessleri_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Chamaeleonidae/Chamaeleo_arabicus/Chamaeleo_arabicus_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Agamidae/Xenagama_taylori/Xenagama_taylori_final_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Agamidae/Uromastyx_benti/Uromastyx_benti_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Agamidae/Phrynocephalus_putjatai/Phrynocephalus_putjatai_final.txt");



        /*
         * Convergence 3
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Nototheniidae/Pagothenia-borchgrevinki/Pagothenia-borchgrevinki_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Rhineuridae/Rhineura_floridana/Rhineura_floridana_final_final.txt");


        /*
         * Convergence 2
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Derichthyidae/Coloconger_cadenati/Coloconger_cadenati_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Congridae/Ariosoma_shiroanago/Ariosoma_shiroanago_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Congridae/Paraconger_notialis/Paraconger_notialis_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Congridae/Conger_japonicus/Conger_japonicus_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Congridae/Heteroconger_hassi/Heteroconger_hassi_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Derichthyidae/Derichthys_serpentinus/Derichthys_serpentinus_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Derichthyidae/Nessorhamphus_ingolfianus/Nessorhamphus_ingolfianus_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Muraenesocidae/Cynoponticus_ferox/Cynoponticus_ferox_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Muraenesox_bagio/Muraenesox_bagio.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Nettastomatidae/Facciolella_oxyrhyncha/Facciolella_oxyrhyncha_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Nettastomatidae/Hoplunnis_punctata/Hoplunnis_punctata_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Nettastomatidae/Nettastoma_parviceps/Nettastoma_parviceps_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Ophichthidae/Ophisurus_macrorhynchos/Ophisurus_macrorhynchos_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Channichthyidae/Chaenocephalus_aceratus/Chaenocephalus_aceratus_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Channichthyidae/Chionodraco_hamatus/Chionodraco_hamatus_final.txt");

        DoTestAgainstVertebrate("data/mitochondrialdna/Nototheniidae/Notothenia_coriiceps/Notothenia_coriiceps_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Plethodontidae/Aneides_flavipunctatus/Aneides_flavipunctatus_final.txt");
        DoTestAgainstVertebrate("data/mitochondrialdna/Plethodontidae/Stereochilus_marginatus/Stereochilus_marginatus_final_final.txt");

        /*
         * Convergence 1
         */
        DoTestAgainstVertebrate("data/mitochondrialdna/Siphonopidae/Siphonops_annulatus/Siphonops_annulatus_final_final.txt");

    }


    public static void DoTestAgainstVertebrate(String pathOfTheTarget) {
        System.out.println("+_+_+_+_+_+_+_+_+_+_+_");
        LZ77Updated lz77Updated = new LZ77Updated();
        List<String> geneOrder_vertebrate = ReadMTGeneOrder.readGeneOrderFromCustomFiles("data/" +
                "mitochondrialdna/vertibrate_final.txt");
        List<String> geneOrder_target = ReadMTGeneOrder.readGeneOrderFromCustomFiles(pathOfTheTarget);
        Map<String, Character> out;
        out = ReadMTGeneOrder.assignCharsToStringList(geneOrder_vertebrate);
//        System.out.println(ReadMTGeneOrder.getTheChangedOutput(geneOrder_sym_ori, out));
        String str1 = ReadMTGeneOrder.getTheChangedOutput(geneOrder_vertebrate, out);
        String str2 = ReadMTGeneOrder.getTheChangedOutput(geneOrder_target, out);
        System.out.println(str1);
        System.out.println(str2);
        lz77Updated.compress(str1, str2);
        lz77Updated.printCompressed();
        System.out.println(ReadMTGeneOrder.getSubsequenceTuples(lz77Updated.getOutput(), str1 + str1));
        List<List<LZ77Updated.Tuple1>> tuples = ReadMTGeneOrder.getSubsequenceTuples(lz77Updated.getOutput(), str1 + str1);
        System.out.println("# of TDs = " + tuples.size());
        int dels = 0;
        for (List<LZ77Updated.Tuple1> t : tuples) {
            dels = dels + t.size() + 1;
        }

        System.out.println("# of Deletions = " + dels);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
    }

}
