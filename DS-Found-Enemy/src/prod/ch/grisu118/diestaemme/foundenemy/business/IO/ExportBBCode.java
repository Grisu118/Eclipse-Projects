package ch.grisu118.diestaemme.foundenemy.business.IO;

import ch.grisu118.diestaemme.foundenemy.business.Objects.Tribe;

public class ExportBBCode {

    private ExportBBCode() {
    }

    public static String[] exportToBBCodeTable(Tribe ownTribe, Tribe enemyTribe) {
        String[] exportString;
        if (ownTribe.getMemberCount() > 10)
            exportString = new String[ownTribe.getMemberCount() / 10];
        else
            exportString = new String[1];
        String start = "[table][**]Eigener Spieler[||]Mögliche Gegner[/**]";
        String end = "[/table]";

        for (int i = 0; i < exportString.length; i++) {
            exportString[i] = start;
        }
        if (ownTribe.getMemberCount() > 10)
            for (int k = 0; k < ownTribe.getMemberCount() / 10; k++) {
                for (int i = 0; i < 10; i++) {
                    if (ownTribe.getPlayer(k * 10 + i).hasTargets()) {
                        String temp = "[*][player]" + ownTribe.getPlayer(k * 10 + i).getUserName()
                                + "[/player][|][player]"
                                + enemyTribe.getPlayer(ownTribe.getPlayer(k * 10 + i).getTargets()[0]).getUserName()
                                + "[/player]";
                        exportString[k] += temp;
                        for (int j = 1; j < ownTribe.getPlayer(k * 10 + i).getTargets().length; j++) {
                            String s1 = "[*][|][player]"
                                    + enemyTribe.getPlayer(ownTribe.getPlayer(k * 10 + i).getTargets()[j])
                                            .getUserName() + "[/player]";
                            exportString[k] += s1;
                        }
                    } else {
                        String temp = "[*][player]" + ownTribe.getPlayer(k * 10 + i).getUserName() + "[/player][|]"
                                + "Keine möglichen Gegner";
                        exportString[k] += temp;
                    }
                }
            }
        else 
            for (int i = 0; i < ownTribe.getMemberCount(); i++) {
                if (ownTribe.getPlayer(i).hasTargets()) {
                    String temp = "[*][player]" + ownTribe.getPlayer(i).getUserName()
                            + "[/player][|][player]"
                            + enemyTribe.getPlayer(ownTribe.getPlayer(i).getTargets()[0]).getUserName()
                            + "[/player]";
                    exportString[0] += temp;
                    for (int j = 1; j < ownTribe.getPlayer(i).getTargets().length; j++) {
                        String s1 = "[*][|][player]"
                                + enemyTribe.getPlayer(ownTribe.getPlayer(i).getTargets()[j])
                                        .getUserName() + "[/player]";
                        exportString[0] += s1;
                    }
                } else {
                    String temp = "[*][player]" + ownTribe.getPlayer(i).getUserName() + "[/player][|]"
                            + "Keine möglichen Gegner";
                    exportString[0] += temp;
                }
            }
        for (int i = 0; i < exportString.length; i++) {
            exportString[i] += end;
        }

        // for (String string : exportString) {
        // System.out.println(string);
        // }
        return exportString;

    }

}
