package inheritance;


interface AcceptJob{
    void accept();
}

interface RejectJob{
    void reject();
}
class OptionsForJob implements AcceptJob,RejectJob {
    public void accept(){
        System.out.println("you accept this Job");
    }
    public void reject(){
        System.out.println("you reject this job");
    }
}

public class Multiple{
    public static void main(String[] args) {
        OptionsForJob job = new OptionsForJob();
        job.accept();
        job.accept();
    }
}
