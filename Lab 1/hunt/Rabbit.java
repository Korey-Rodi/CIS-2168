public class Rabbit extends Animal {


    public Rabbit(Model model, int row, int column) {
        super(model, row, column);
    }
    
    int decideMove() {
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            // Move diagonally away from the fox to enter its blind spots
            if(look(i) == Model.FOX){
                if(canMove(Model.turn(i,5))){
                    return Model.turn(i,5);
                }
                if(canMove(Model.turn(i,3))){
                    return Model.turn(i,3);
                }
                if(canMove(Model.turn(i,7))){
                    return Model.turn(i,7);
                }
                if(canMove(Model.turn(i,1))){
                    return Model.turn(i,1);
                }
            }
        }
             return Model.STAY;
    }
}