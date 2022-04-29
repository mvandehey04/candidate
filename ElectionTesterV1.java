public class ElectionTesterV1 
{
    public static void main(String args[]){
        // array containing 5 candidate object w/ their name & # of votes
        Candidate[] candidates = new Candidate[5];

        // 5 candidate objects
        candidates[0] = new Candidate("Taylor Swift", 1313);
        candidates[1] = new Candidate("Kesha", 894);
        candidates[2] = new Candidate("Olivia Rodrigo", 567);
        candidates[3] = new Candidate("Britney Spears", 521);
        candidates[4] = new Candidate("Marina", 1254);

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
    public static void printCandidates(Candidate[] itemList){
        System.out.println("Raw Election Data:" + "\n");
        for(int i = 0; i < itemList.length; i++){
            System.out.println(itemList[i].toString());
        }
    }

    // count the total of the votes for all the candidates
    public static int returnTotVotes(Candidate[] itemList){
        int totVotes = 0;
        for(int i = 0; i < itemList.length; i++){
            totVotes += itemList[i].getVotes();
        }
        return totVotes;
    }

    // create a table w/ columns for the candidate name, votes, % of tot votes
    public static void printTable(Candidate[] itemList){
        double percentVote = 0.0;

        System.out.println("\n" + "Election Results:");
        System.out.printf("%26s %23s", "Votes", "% of Total");
        System.out.printf("\n %1s %17s %18s \n", "Candidate", "Received", "Votes");
        System.out.println("=======================================================");

        // table of data
        for(int i = 0; i < itemList.length; i++){
            percentVote = (itemList[i].getVotes() / (double)(returnTotVotes(itemList)) * 100);
            System.out.printf("%-20s %-20d %-1.2f \n", itemList[i].getName(), itemList[i].getVotes(), percentVote);
        }

        // print total number of votes
        System.out.println("\n" + "The total number of votes is: " + returnTotVotes(itemList) + "\n");

    }

    // find candidate by name and change the name
    public static void changeCandidate(Candidate[] itemList, String find, String replace){
        for(int i = 0; i < itemList.length; i++){
            if(itemList[i].getName().equals(find)){
                itemList[i] = new Candidate(replace, itemList[i].getVotes());
            }
        }

        System.out.println("\n" + "<<Changing " + find + " to " + replace + ">>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);

    }

    // find by name and change the number of votes
    public static void changeVotes(Candidate[] itemList, String find, int replace){
        for(int i = 0; i < itemList.length; i++){
            if(itemList[i].getName().equals(find)){
                itemList[i] = new Candidate(find, replace);
            }
        }

        System.out.println("\n" + "<<Changing " + find + " votes to " + replace + ">>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);

    }

    // find candidate by name and replace both the name and number of votes 
    public static void changeCandAndVot(Candidate[] itemList, String name, String newName, int votes){

        for(int i = 0; i < itemList.length; i++){
            if(itemList[i].getName().equals(name)){
                itemList[i] = new Candidate(newName, votes);
            }
        }

        System.out.println("\n" + "<<Changing " + name + " to " + newName + " and votes to " + votes + ">>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);
    }
    

}