package model.societe;

import etu1819.annotation.*;
import etu1819.framework.ModelView;
import etu1819.framework.FileUpload;

import java.sql.Date;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

public class Emp {
    String nom;
    int age;
    float note;
    Date embauche;
    boolean status;
    float prime;
    FileUpload file = null;
    static int appels = 0; 
    HashMap<String, Object> session;

    // _ _ _ Constructors _ _ _

    
    public Emp(){
        Emp.appels ++;
        //System.out.println("---> INSTANCES DE EMP: "+Emp.appels);
    }

    // _ _ _ MODEL Methods _ _ _
    @Urls(url = "prime")
    public float computePrime(@Args(argName = "note")float note, @Args(argName = "salaire")float salaire){
        System.out.println("--> Method invocation: PRIME ");
        System.out.println("### Instances de Emp: "+ Emp.appels);
        return note*salaire;
    }

    // _ _ _ CONTROLLER Methods _ _ _
    @Urls(url = "voidArgs")
    public ModelView embaucher(){
        System.out.println("--> Method invocation: VOIDARGS ");
        System.out.println("### Instances de Emp: "+ Emp.appels);
        ModelView mv = new ModelView();
        
        // vue destinatrice
        mv.setView("emp-list.jsp");

        //elements de donnees a passer a la vue
        Vector<Emp> liste = new Vector<Emp>();
        Emp e = new Emp();
            
            
        e.setNom("MEHTODE SANS ARGUMENTS INVOQUEE");        
        liste.add(e);
        

        // ajout de la liste aux donnees a passer
        mv.addItem("liste", liste);

        return mv;
    }

    @Urls(url = "obejctToJson.do")
    @IsJson()
    public Emp getAll2(){
        System.out.println("--> Method invocation: GETALLEMP ");
        System.out.println("### Instances de Emp: "+ Emp.appels);

        
        Emp e = new Emp(),
            e2 =  new Emp(),
            e3 =  new Emp();
            
        e.setNom("E1");

        return e;
    }

    @Urls(url = "mvToJson.do")
    public ModelView getAll(){
        System.out.println("--> Method invocation: GETALLEMP ");
        System.out.println("### Instances de Emp: "+ Emp.appels);

        ModelView mv = new ModelView();
        mv.setIsJson(true);
        // vue destinatrice
        mv.setView("emp-list.jsp");

        //elements de donnees a passer a la vue
        Vector<Emp> liste = new Vector<Emp>();
        Emp e = new Emp(),
            e2 =  new Emp(),
            e3 =  new Emp();
            
        e.setNom("Lili");
        e2.setNom("Nato");
        e3.setNom("Miki");
        liste.add(e);
        liste.add(e2);
        liste.add(e3);

        // ajout de la liste aux donnees a passer
        mv.addItem("liste", liste);
        mv.setIsJson(true);

        return mv;
    }

    @Urls(url = "showOneEmp.do")
    @Auth(profile = "nato")
    @Session()
    public ModelView listeEmpSaisi( @Args(argName = "salaire") float salaire){
        System.out.println("--> Method invocation: SHOWONEEMP ");
        System.out.println("### Instances de Emp: "+ Emp.appels);

        ModelView mv = new ModelView();
        Vector<Emp> liste = new Vector<Emp>();
        liste.add(this);
        mv.addItem("liste", liste);
        mv.addItem("connectedProfile", this.session.get("connectedProfile"));
        mv.addSessionItem("cle", "valeur");

        System.out.println("Contenu de la variable de session: ");
        for (Map.Entry<String, Object> entry : this.session.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("Clé : " + key + ", Valeur : " + value);
        }
    
        this.setPrime(computePrime(this.note, salaire));
        
        //System.out.println("Nom:\t"+ this.getNom());
        //System.out.println("Age:\t"+ this.getAge());
        //System.out.println("Date embauche: "+ this.getEmbauche().toString());

        mv.setView("emp-list.jsp");
        //System.out.println("INSTANCES DE EMP: "+Emp.appels);
        return mv;
    }

    //_ _ _ GET SET _ _ _

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getEmbauche() {
        return embauche;
    }

    public void setEmbauche(Date embauche) {
        this.embauche = embauche;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus(){
        return this.status;
    }

    public float getPrime() {
        return prime;
    }

    public void setPrime(float prime) {
        this.prime = prime;
    }

    public FileUpload getFile() {
        return file;
    }

    public void setFile(@Args(argName = "file")FileUpload file) {
        this.file = file;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
    public int getAppels() {
        return appels;
    }
    public void setAppels(int appels) {
        this.appels = appels;
    }

    public HashMap<String, Object> getSession() {
        return session;
    }

    public void setSession(HashMap<String, Object> session) {
        this.session = session;
    }

}
