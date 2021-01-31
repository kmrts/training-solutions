package job;

public class Job implements Comparable<Job>{
    private final int priority; // 1 - 10 skálán osztályozzuk a prioritást
    private final String jobDescription;
    private final boolean urgent; // minden olyan job esetén true, ahol a prioritás < 5

    public Job(int priority, String jobDescription) {
        if(priority>10 || priority<1){
            throw new IllegalArgumentException("Must be 1- 10");
        }
        this.priority = priority;
        this.jobDescription = jobDescription;
        this.urgent = priority<5;
    }

    public int getPriority() {
        return priority;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public boolean isUrgent() {
        return urgent;
    }

    @Override
    public int compareTo(Job o) {  ////
        return this.priority -o.priority;
    }
}
