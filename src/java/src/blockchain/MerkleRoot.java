package blockchain;

import java.util.ArrayList;
import java.util.Arrays;

import static projectutils.HashUtil.applySha256;

class MerkleRoot {
    private ArrayList<String> listePrep;
    private String root;
    private int nb;

    MerkleRoot(String transactions[]) {
        this.root = "Null";
        int nb = transactions.length > 1 ? (Integer.highestOneBit(transactions.length - 1) << 1) : 1;
        this.nb = nb;
        listePrep = new ArrayList<>(Arrays.asList(transactions));
        if (transactions.length != nb) {
            if (transactions.length % 2 == 0) {
                for (int i = transactions.length; i < nb; i += 2) {
                    listePrep.add(transactions[transactions.length - 2]);
                    listePrep.add(transactions[transactions.length - 1]);
                }
            } else {
                for (int i = transactions.length; i < nb; ++i) {
                    listePrep.add(transactions[transactions.length - 1]);
                }
            }
        }
        //System.out.println(this.listePrep + "\n" + this.nb + " " + this.listePrep.size());
    }

    private String computeRoot(int nb, int deb) {

        if (nb == 1) {
            return applySha256(listePrep.get(0));
        }

        if (nb == 2) {
            return applySha256(applySha256(listePrep.get(deb)) + applySha256(listePrep.get(1 + deb)));
        } else if (nb > 3) {
            int t = nb >> 1;
            return applySha256(computeRoot(t, deb) + computeRoot(t, deb + t));
        }
        return this.root;
    }

    String getRoot() {
        if (this.root.equals("Null")) {
            this.root = this.computeRoot(this.nb, 0);
            return this.root;
        }
        return this.root;
    }
}