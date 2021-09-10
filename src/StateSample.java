public class StateSample {
    public static void main(String[] args) {
        VendorMachine machine = new VendorMachine();
        machine.insertQuarter();
        machine.insertQuarter();
        machine.turnCrank();
    }
}

abstract class State{
    int count = 10;
    abstract void insertQuarter(VendorMachine machine);
    abstract void turnCrank(VendorMachine machine);
}

class VendorMachine {
    State state = new NoQuarter();

    void insertQuarter() {
        state.insertQuarter(this);
    }

    void turnCrank() {
        state.turnCrank(this);
    }
}

class NoQuarter extends State{

    @Override
    void insertQuarter(VendorMachine machine) {
        System.out.println("Inserting a coin");
        machine.state = new HasQuarter();
    }

    @Override
    void turnCrank(VendorMachine machine) {
        System.out.println("Insert a coin!");
    }
}

class HasQuarter extends State{

    @Override
    void insertQuarter(VendorMachine machine) {
        System.out.println("You cant insert another coin");
    }

    @Override
    void turnCrank(VendorMachine machine) {
        if(count <= 0){
            machine.state = new SoldOut();
        }else{
            System.out.println("Selling...");
            count--;
            machine.state = new NoQuarter();
        }
    }
}

class SoldOut extends State{

    @Override
    void insertQuarter(VendorMachine machine) {
        System.out.println("No products.");
    }

    @Override
    void turnCrank(VendorMachine machine) {
        System.out.println("No products.");
    }
}

// TOO MUCH IF/ELSE

//enum VendorMachineState{ SOLD_OUT, NO_QUARTER, HAS_QUARTER }
//class VendorMachine{
//    int count = 10;
//    VendorMachineState state = VendorMachineState.NO_QUARTER;
//
//    public void insertQuarter(){
//        if(state.equals(VendorMachineState.HAS_QUARTER)){
//            System.out.println("You cant insert another quarter");
//        } else if(state.equals(VendorMachineState.NO_QUARTER)){
//            state = VendorMachineState.HAS_QUARTER;
//        } else if(state.equals(VendorMachineState.SOLD_OUT)){
//            System.out.println("No products.");
//        }
//
//
//    }
//
//    public void turnCrank(){
//        if(state.equals(VendorMachineState.HAS_QUARTER)){
//            if(count <= 0){
//                state = VendorMachineState.SOLD_OUT;
//            }else {
//                System.out.println("Selling...");
//                state = VendorMachineState.NO_QUARTER;
//                count --;
//            }
//        } else if(state.equals(VendorMachineState.NO_QUARTER)){
//            System.out.println("Insert a coin!");
//        }
//    }
//
//}
