package org.msu.adiesha.test.finaltests;

import org.msu.adiesha.utils.KendallTauDistance;
import org.msu.adiesha.utils.ReadMTGeneOrder;
import org.msu.adiesha.utils.StabilizedPermutations;
import org.msu.adiesha.utils.Utils;

import java.util.List;
import java.util.Map;

public class TestAgainstVertebrateWithKendalTau {
    public static void main(String[] args) {
        /*
         * Convergence 11 (Boulengerula taitana, Clinocottus analis)
         */
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Cottidae/Clinocottus_analis/Clinocottus_analis_final.txt", "Clinocottus_analis");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Herpelidae/Boulengerula_taitana/Boulengerula_taitana_final_final.txt", "Boulengerula_taitana");

        /*
         * Convergence 10 (Lampris guttatus, Hapalogenys analis, Trichiurus japonicus)
         */
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Lampridae/Lampris_guttatus/Lampris_guttatus_final.txt", "Lampris_guttatus");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Hapalogenyidae/Hapalogenys_analis/Hapalogenys_analis_final.txt", "Hapalogenys_analis");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Trichiuridae/Trichiurus_japonicus/Trichiurus_japonicus_final.txt", "Trichiurus_japonicus");


        /*
         * Convergence 9
         */
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Monacanthidae/Rudarius_ercodes/Rudarius_ercodes_final.txt", "Rudarius_ercodes");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Umbridae/Dallia_pectoralis/Dallia_pectoralis_final.txt", "Dallia_pectoralis");

        /*
         * Convergence 8 (
         */

        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Platytroctidae/Normichthys_operosus/Normichthys_operosus_final.txt", "Normichthys_operosus");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Ambassidae/Ambassis_gymnocephalus/Ambassis_gymnocephalus_final.txt", "Ambassis_gymnocephalus");


        /*
         * Convergence 7
         */
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Aulorhynchidae/Aulorhynchus_flavidus/Aulorhynchus_flavidus_final.txt", "Aulorhynchus_flavidus");


        /*
         * Convergence 6
         */
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Macrouridae/Trachyrincus_murrayi/Trachyrincus_murrayi_final.txt", "Trachyrincus_murrayi");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Macrouridae/Squalogadus_modificatus/Squalogadus_modificatus_final.txt", "Squalogadus_modificatus");


        /*
         * Convergence 5
         */
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Macrouridae/Cetonurus_globiceps/Cetonurus_globiceps_final.txt", "Cetonurus_globiceps");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Macrouridae/Coelorinchus_kishinouyei/Coelorinchus_kishinouyei_final.txt", "Coelorinchus_kishinouyei");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Macrouridae/Ventrifossa_garmani/Ventrifossa_garmani_final.txt", "Ventrifossa_garmani");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Gekkonidae/Uroplatus_fimbriatus/Uroplatus_fimbriatus_final.txt", "Uroplatus_fimbriatus");


        /*
         * Convergence 4
         */
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Kurtidae/Kurtus_gulliveri/Kurtus_gulliveri_final.txt", "Kurtus_gulliveri");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Benthophilinae/Ponticola_kessleri/Ponticola_kessleri_final.txt", "Ponticola_kessleri");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Chamaeleonidae/Chamaeleo_arabicus/Chamaeleo_arabicus_final.txt", "Chamaeleo_arabicus");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Agamidae/Xenagama_taylori/Xenagama_taylori_final_final.txt", "Xenagama_taylori_final");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Agamidae/Uromastyx_benti/Uromastyx_benti_final.txt", "Uromastyx_benti");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Agamidae/Phrynocephalus_putjatai/Phrynocephalus_putjatai_final.txt", "Phrynocephalus_putjatai");



        /*
         * Convergence 3
         */
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Nototheniidae/Pagothenia-borchgrevinki/Pagothenia-borchgrevinki_final.txt", "Pagothenia-borchgrevinki");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Rhineuridae/Rhineura_floridana/Rhineura_floridana_final_final.txt", "Rhineura_floridana_final");


        /*
         * Convergence 2
         */
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Derichthyidae/Coloconger_cadenati/Coloconger_cadenati_final.txt", "Coloconger_cadenati");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Congridae/Ariosoma_shiroanago/Ariosoma_shiroanago_final.txt", "Ariosoma_shiroanago");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Congridae/Paraconger_notialis/Paraconger_notialis_final.txt", "Paraconger_notialis");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Congridae/Conger_japonicus/Conger_japonicus_final.txt", "Conger_japonicus");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Congridae/Heteroconger_hassi/Heteroconger_hassi_final.txt", "Heteroconger_hassi");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Derichthyidae/Derichthys_serpentinus/Derichthys_serpentinus_final.txt", "Derichthys_serpentinus");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Derichthyidae/Nessorhamphus_ingolfianus/Nessorhamphus_ingolfianus_final.txt", "Nessorhamphus_ingolfianus");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Muraenesocidae/Cynoponticus_ferox/Cynoponticus_ferox_final.txt", "Cynoponticus_ferox");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Muraenesox_bagio/Muraenesox_bagio.txt", "Muraenesox");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Nettastomatidae/Facciolella_oxyrhyncha/Facciolella_oxyrhyncha_final.txt", "Facciolella_oxyrhyncha");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Nettastomatidae/Hoplunnis_punctata/Hoplunnis_punctata_final.txt", "Hoplunnis_punctata");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Nettastomatidae/Nettastoma_parviceps/Nettastoma_parviceps_final.txt", "Nettastoma_parviceps");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Ophichthidae/Ophisurus_macrorhynchos/Ophisurus_macrorhynchos_final.txt", "Ophisurus_macrorhynchos");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Channichthyidae/Chaenocephalus_aceratus/Chaenocephalus_aceratus_final.txt", "Chaenocephalus_aceratus");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Channichthyidae/Chionodraco_hamatus/Chionodraco_hamatus_final.txt", "Chionodraco_hamatus");

        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Nototheniidae/Notothenia_coriiceps/Notothenia_coriiceps_final.txt", "Notothenia_coriiceps");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Plethodontidae/Aneides_flavipunctatus/Aneides_flavipunctatus_final.txt", "Aneides_flavipunctatus");
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Plethodontidae/Stereochilus_marginatus/Stereochilus_marginatus_final_final.txt", "Stereochilus_marginatus_final");

        /*
         * Convergence 1
         */
        DoTestAgainstVertebrateKendallTau("data/mitochondrialdna/Siphonopidae/Siphonops_annulatus/Siphonops_annulatus_final_final.txt", "Siphonops_annulatus_final");
    }

    private static void DoTestAgainstVertebrateKendallTau(String pathOfTheTarget, String name) {
        System.out.println("+_+_+_+_+_+_+_+_+_+_+_");
        System.out.println("Performing test against " + name + " vs vertebrate using alpha = 2");

        List<String> geneOrder_vertebrate = ReadMTGeneOrder.readGeneOrderFromCustomFiles("data/" +
                "mitochondrialdna/vertibrate_final.txt");
        List<String> geneOrder_target = ReadMTGeneOrder.readGeneOrderFromCustomFiles(pathOfTheTarget);
        Map<String, Character> out;
        out = ReadMTGeneOrder.assignCharsToStringList(geneOrder_vertebrate);
        String str1 = ReadMTGeneOrder.getTheChangedOutput(geneOrder_vertebrate, out);
        String str2 = ReadMTGeneOrder.getTheChangedOutput(geneOrder_target, out);
        System.out.println(str1);
        System.out.println(str2);
        StabilizedPermutations.StabilizedPermsDTO stabilizedPermsDTO =
                StabilizedPermutations.getGeneralizedStabilizedPermutations(str1, str2);
        System.out.println("Stabilized Permutations -> .....");
        System.out.println(stabilizedPermsDTO.source_stab);
        System.out.println(stabilizedPermsDTO.target_stab);
        StabilizedPermutations.mapStabilizedPerms(stabilizedPermsDTO);
        int tendalkdist = KendallTauDistance.calculateKendallTauDistance(stabilizedPermsDTO.targetPerm);
        System.out.println(tendalkdist);
        System.out.println(stabilizedPermsDTO.source_additions);
        System.out.println(stabilizedPermsDTO.target_reduction);
        System.out.println("+++++++++++++++++++++++++++++++");

        Utils.ResultSet resultSet = new Utils.ResultSet();
        resultSet.sourceName = name;
        resultSet.targetName = "Vertebrate";

        Utils.writeResultsToFile(resultSet, stabilizedPermsDTO, tendalkdist, "data/result/kendalTuauVertebraete.txt");
    }


}
