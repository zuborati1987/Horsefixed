
public class Display {
    int finish = 250;
    public void horses(String name,int j, double speed){
        int i;
        System.out.println(name);
        for(i = 0; i < j; i += (20 - speed/10)/2){
            System.out.print("   ");
            //if(i >= j/4) break;
        }
        System.out.println("~___/^");
        for(i = 0; i < j; i += (20 - speed/10)/2){
            System.out.print("  ^");
            //if(i >= j/4) break;
        }
        System.out.println("/\\ /\\\n");
        //System.out.println(i);
        if(i >= speed*8){
            this.finish = 0;
        }else {
            if(i > 200){
                this.finish = 0;
            }
        }
        
    }

    public void display(Kennel kennel, Race race) throws Exception{
        Kennel LeKennel = kennel;
        Race racer = race;
        String name = new String();
        double speed = 0;
        //racer.getGoToArr();
        //name = "Béla";
        for(int j = 0; j < this.finish; j++){
            for(int i = 0; i < 150; i++){//upper corner
                System.out.print("_");
            }
            //System.out.println("");
            for(int l = 0; l < 5; l++){
                speed = LeKennel.getHorseList().get(racer.getGoToArr().get(l)).getActualSpeed();
                name = LeKennel.getHorseList().get(racer.getGoToArr().get(l)).getName();
                horses(name, j, speed);
            }

            for(int i = 0; i < 150; i++){//lower corner
                System.out.print("_");
            }
            for(int i = 0; i < 10; i++){//screen clear
                System.out.println("");
            }

            Thread.sleep(60);
        }

        //System.out.println("Lófaszt a picsádba!!!!!");
    }

    /*public void porn1(){
        System.out.println("  /^");
        System.out.println("~/|___/^");
        System.out.println("/\\/\\ /\\");
    }
    public void porn2(){
        System.out.println("  /^");
        System.out.println("~\\|___/^");
        System.out.println("/\\/\\ /\\");
    }*/

    public void asciiHorsePorn()throws Exception{
        for(int j = 0; j < 50; j++){
            System.out.println("The winner got it's trophy: ");
            if(j % 2 != 0){
                //porn1();
                System.out.println("  /^");
                System.out.println("~/|___/^");
                System.out.println("/\\/\\ /\\");
            }else{
                //porn2();
                System.out.println("  /^");
                System.out.println("~\\|___/^");
                System.out.println("/\\/\\ /\\");
            }
            /*if(j % 2 == 0){
                porn1();
            }else{
                porn2();
            }*/
            for(int i = 0; i < 25; i++){//screen clear
                System.out.println("");
            }
            Thread.sleep(100);
        }
        System.out.println("They live happily ever after!");
    }

    public void asciiHorseShit(){
        System.out.println("  ^ ~___/^");
        System.out.println(" ^^^/\\ /\\");
    }
    
}