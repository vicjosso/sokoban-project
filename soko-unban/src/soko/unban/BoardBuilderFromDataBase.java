package soko.unban;

/**
 *
 * @author Victor Josso
 */
public class BoardBuilderFromDataBase implements BoardBuilder {
    
    //voir infos dans découpage entrée player
    
    @Override
    public void reader(String name, DataBase db){
        //commande sql nécessaire ou au moins découpage
        
        
    }
    
    @Override
    public void writer(DataBase db, String[] map){
        //utiliser le constructeur de la classe board ainsi qu'un switch pour l'attribution des cases, voir pour supprimer l'interface
    }
}
