package cleancode;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ConstructionCost{
	private static final Logger LOGGER= LogManager.getLogger(ConstructionCost.class);
    private int material_standard_id;
    private float house_area;   //in square feet
    private boolean is_fully_automated;
    public ConstructionCost(){
        int flag = 1;
        Scanner sc = new Scanner(System.in);
        //PrintStream obj =  new PrintStream(new FileOutputStream(FileDescriptor.out));
        do {
            LOGGER.fatal("Press 1 for standard materials\n");
            LOGGER.fatal("Press 2 for above standard materials\n");
            LOGGER.fatal("Press 3 for high standard materials\n");
            LOGGER.fatal("Enter your choice = ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    this.material_standard_id = 1;
                    LOGGER.fatal("The material standard selected is standard material\n");
                    flag = 0;
                    break;
                case 2:
                    this.material_standard_id = 2;
                    LOGGER.fatal("The material standard selected is above standard material\n");
                    flag = 0;
                    break;
                case 3:
                    this.material_standard_id = 3;
                    LOGGER.fatal("The material standard selected is high standard material\n");
                    flag = 0;
                    break;
                default:
                	LOGGER.fatal("Wrong choice selected\n");
            }
        }while (flag==1);
        LOGGER.fatal("Enter the house area = ");
        this.house_area = sc.nextFloat();
        LOGGER.fatal("Press y to get fully automated features = ");
        sc.nextLine();
        char ch = sc.next().charAt(0);
        if(ch=='Y' ||ch=='y')
            this.is_fully_automated = true;
        else
            this.is_fully_automated = false;
    }
    void calculate(){
        float cost = 1;
        PrintStream obj =  new PrintStream(new FileOutputStream(FileDescriptor.out));
        LOGGER.fatal("The calculated cost = ");
        if(this.material_standard_id==1)
            cost = 1200;
        else if(this.material_standard_id==2)
            cost = 1500;
        else if(this.material_standard_id==3)
            cost = 1800;
        //automation cost calculated as 2500-1800=700
        if(this.is_fully_automated)
            cost += 700;
        LOGGER.fatal(cost*this.house_area+"\n");
    }
}