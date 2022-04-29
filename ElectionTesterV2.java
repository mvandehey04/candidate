import java.util.ArrayList;
public class ElectionTesterV2 {
    // arrayList version of election tester v1
    public static void main(String args[]){
        // arrayList containing 5 candidate object w/ their name & # of votes
        ArrayList<Candidate> candidates = new ArrayList<Candidate>();

        // 5 candidate objects
        candidates.add(new Candidate("Taylor Swift", 1313));
        candidates.add(new Candidate("Kesha", 894));
        candidates.add(new Candidate("Olivia Rodrigo", 567));
        candidates.add(new Candidate("Britney Spears", 521));
        candidates.add(new Candidate("Marina", 1254));

        // raw election data
        printCandidates(candidates);

        //election results
        printTable(candidates);

        // replace name
        changeCandidate(candidates, "Olivia Rodrigo", "Katy Perry");

        // replace votes
        changeVotes(candidates, "Kesha", 1243);

        // replace votes and candidate
        changeCandAndVot(candidates, "Taylor Swift", "Ariana Grande", 1348);

    }
    // print candidtate names & votes
    public static void printCandidates(ArrayList<Candidate> itemList){
        System.out.println("Raw Election Data:" + "\n");
        for(Candidate c : itemList){
            System.out.println(c.toString());
        }
    }

    // counts the total votes for all the candidates
    public static int returnTotVotes(ArrayList<Candidate> itemList){
        int totVotes = 0;
        for(Candidate c : itemList){
            totVotes += c.getVotes();
        }
        return totVotes;
    }

    // creates a table w/ columns for the candidate name, votes, % of tot votes
    // print a statement showing the total number of votes for the election
    public static void printTable(ArrayList<Candidate> itemList){
        double percentVote = 0.0;

        System.out.println("\n" + "Election Results:");
        System.out.printf("%26s %23s", "Votes", "% of Total");
        System.out.printf("\n %1s %17s %18s \n", "Candidate", "Received", "Votes");
        System.out.println("=======================================================");

        // table data
        for(Candidate c : itemList){
            percentVote = (c.getVotes() / (double)(returnTotVotes(itemList)) * 100);
            //"%-9d %-17s %-13d
            System.out.printf("%-20s %-20d %-1.2f \n", c.getName(), c.getVotes(), percentVote);
        }

         // print total number of votes
         System.out.println("\n" + "The total number of votes is: " + returnTotVotes(itemList) + "\n");

    }

     // find candidate by name and change the name
     public static void changeCandidate(ArrayList<Candidate> itemList, String find, String replace){
        for(int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getName().equals(find)){
                itemList.set(i, new Candidate(replace, itemList.get(i).getVotes()));
            }
        }

        System.out.println("\n" + "<<Changing " + find + " to " + replace + ">>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);

    }

    // find by name and change the number of votes
    public static void changeVotes(ArrayList<Candidate> itemList, String find, int replace){
        for(int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getName().equals(find)){
                itemList.set(i, new Candidate(find, replace));
            }
        }

        System.out.println("\n" + "<<Changing " + find + " votes to " + replace + ">>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);

    }

    // find candidate by name and replace both the name and number of votes 
    public static void changeCandAndVot(ArrayList<Candidate> itemList, String name, String newName, int votes){
        for(int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getName().equals(name)){
                itemList.set(i, new Candidate(newName, votes));
            }
        }

        System.out.println("\n" + "<<Changing " + name + " to " + newName + " and votes to " + votes + ">>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);
    }
}
