package packageModel;

import java.util.GregorianCalendar;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class Reappro {

    private Integer iDReappro;
    private GregorianCalendar dateReappro;
    private String note, etat;
    private Fournisseur fourn;

    /**
     *
     * @param dR date du reapprovisionnement
     * @param n  note sur le reapprovisionnement
     * @param e  etat du reapprovisionnement
     * @param f  fournisseur du reapprovisionnement
     * @see String
     * @see Fournisseur
     * @see GregorianCalendar
     */
    public Reappro(GregorianCalendar dR, String n, String e, Fournisseur f) {
        this.dateReappro = dR;
        this.note = n;
        this.etat = e;
        this.fourn = f;
    }

    /**
     *
     * @param idR id du reapprovisionnement
     * @param dR  date du reapprovisionnement
     * @param e   etat du reapprovisionnement
     * @param f   fournisseur du reapprovisionnement
     * @see String
     * @see Fournisseur
     * @see Integer
     * @see GregorianCalendar
     */
    public Reappro(Integer idR, GregorianCalendar dR, String e, Fournisseur f) {
        this.iDReappro = idR;
        this.dateReappro = dR;
        this.etat = e;
        this.fourn = f;
    }

    /**
     *
     * @return date du reapprovisionnement
     * @see GregorianCalendar
     */
    public GregorianCalendar getReapDate() {
        return this.dateReappro;
    }

    /**
     *
     * @return note sur le reapprovisionnement
     * @see String
     */
    public String getNote() {
        return this.note;
    }

    /**
     *
     * @return etat du reapprovisionnement
     * @see String
     */
    public String getEtat() {
        return this.etat;
    }

    /**
     *
     * @return id du reapprovisionnement
     * @see Integer
     */
    public Integer getiDReappro() {
        return iDReappro;
    }

    /**
     *
     * @return fournisseur du reapprovisionnement
     * @see Fournisseur
     */
    public Fournisseur getFourn() {
        return fourn;
    }

    /**
     *
     * @param note note sur le reapprovisionnement
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     *
     * @param etat etat du reapprovisionnement
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }
}
