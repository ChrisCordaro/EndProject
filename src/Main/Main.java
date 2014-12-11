package Main;
/*package edu.marist.cmpt220l;

import edu.marist.cmpt220l.competitions.CompetitionManager;
import edu.marist.cmpt220l.competitions.ICompetition;
import edu.marist.cmpt220l.events.Event;
import edu.marist.cmpt220l.events.EventManager;
import edu.marist.cmpt220l.olympians.Olympian;
import edu.marist.cmpt220l.olympians.OlympianManager;
import edu.marist.cmpt220l.teams.Team;
import edu.marist.cmpt220l.teams.TeamManager;
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Competitions.CompetitionManager;
import Competitions.ICompetition;
import Events.Event;
import Events.EventManager;
import Olympians.Olympian;
import Olympians.OlympianManager;
import Queues.QueueItemList;
import Stacks.StackItemList;
import Teams.Team;
import Teams.TeamManager;


/**
 * This is the main class for the Lawn Game Olympics program.  This program sets up an interactive
 * console session that allows the user to track the olympians, teams, events, and competitions
 * that occur throughout the day.
 */
public class Main {

    private OlympianManager om;
    private TeamManager tm;
    private EventManager em;
    private CompetitionManager cm;
    private BufferedReader input;
    private StackItemList sil;
    
    
    /**
     * Construct a new instance of the Main class
     *
     * @param filePath the path to the lgoo file which contains the olympians
     */
    public Main(String filePath)
    {
        om = new OlympianManager(filePath);
        tm = new TeamManager(om);
        em = new EventManager(tm);
       // cm = new CompetitionManager(em, tm);
        cm = new CompetitionManager(em, em.getEvents());
    }

    /**
     * Run the application
     */
    public void Run()
    {
        //display the title
        System.out.println("Welcome to Lawn Game Olympics");
        System.out.println("-----------------------------");
        System.out.println();
        System.out.print("Enter Command: ");

        //read commands from System.in
        input = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {
            //keep reading input until there is nothing left to read. Note this loop
            //also breaks if the user enters "q" or "quit".
            while ((line = input.readLine()) != null) {
                line = line.toLowerCase().trim(); // make lowercase for usability

                if("o".equals(line) || "olympians".equals(line))
                    listOlympians();
                else if("e".equals(line) || "events".equals(line))
                    listEvents();
                else if("t".equals(line) || "teams".equals(line))
                    listTeams();
                else if("c".equals(line) || "competitions".equals(line))
                    listCompetitions();
                else if("sc".equals(line) || "startcompetition".equals(line))
                	cm = new CompetitionManager(em, em.getEvents());
                else if("h".equals(line) || "help".equals(line))
                    help();
                else if("queue".equals(line))
                	initializeQueue();
                else if("q".equals(line) || "quit".equals(line))
                    break;
                else
                    System.out.println("Invalid command, try again (enter 'h' for a list of commands)");

                System.out.println();
                System.out.print("Enter Command: ");
            }
        }
        catch(IOException ioe)
        {
            System.out.println("Error reading command");
        }
    }

    /**
     * List the olympians within the application
     */
    private void listOlympians()
    {
        System.out.println("Lawn Game Olympics Olympians");
        System.out.println();

        Olympian[] olympians = om.getOlympians();

        System.out.println("Name        Sex     Age");
        System.out.println("----------  ------  ---");
        for(int i=0; i < olympians.length; i++)
            System.out.printf("%-10s  %-6s  %3d\n", olympians[i].getName(), olympians[i].getSex(), olympians[i].getAge());
    }

    /**
     * List the events within the application
     */
    private void listEvents()
    {
        System.out.println("Lawn Game Olympics Events");
        System.out.println();

        Event[] events = em.getEvents();

        System.out.println("Name         Play To  Exact  Distance  Extra");
        System.out.println("-----------  -------  -----  --------  --------------------------------------------------");
        for(int i=0; i < events.length; i++)
            System.out.printf("%-11s  %7d  %-5s  %8d  %-50s\n", events[i].getName(), events[i].getPlayTo(), events[i].isPlayToExact(), events[i].getPlayDistance(), events[i].getExtraInfo());
    }

    /**
     * List the teams within the application
     */
    private void listTeams()
    {
        System.out.println("Lawn Game Olympics Teams");
        System.out.println();

        Team[] teams = tm.getTeams();

        System.out.println("Name                  Wins  Losses");
        System.out.println("--------------------  ----  ------");
        for(int i=0; i < teams.length; i++)
            System.out.printf("%-20s  %4d  %6d\n", teams[i], teams[i].getNumWins(), teams[i].getNumLosses());
    }

    /**
     * List the current competitions within the application
     */
    private void listCompetitions()
    {
        System.out.println("Lawn Game Olympics Competitions");
        System.out.println();

        ICompetition[] competitions = cm.getCompetitions();

        System.out.println("Event        Home Team             Away Team");
        System.out.println("-----------  --------------------  --------------------");
        for(int i=0; i < competitions.length; i++)
            System.out.printf("%-11s  %-20s  %-20s\n", competitions[i].getEvent().getName(), competitions[i].getHomeTeam(), competitions[i].getAwayTeam());
    }
    /**
     * Place every team on the queue 
     */
    
    private void initializeQueue(){
    	QueueItemList q = new QueueItemList();
        q.randomQueue(tm.getTeams());
        
        //Not sure if dequeueing is needed.
        //Trying to test if teams were infact added to the queue
        while(q.isEmpty() == false){
        q.dequeue();
        }
      
    }
    
    public void listTeamsPlacing(){
    	//for each event played in competition manager
    	//list each placing
    	
    	Event [] events = em.getEvents();
    	for(int i = 0; i > events.length; i++){
    		
    		
    	}
    }


    /**
     * Start a new competition within the application
     *
     * @throws IOException
     */
  /*  private void startCompetition() throws IOException
    {
        System.out.println("Lawn Game Olympics New Competition");
        System.out.println();
        Event[] freeEvents = cm.getFreeEvents();
        Team[] freeTeams = cm.getFreeTeams();

        if(freeEvents.length < 1)
        {
            System.out.println("No free event, you must end an event before starting a new one");
            return;
        }
        if(freeTeams.length < 2)
        {
            System.out.println("Two teams are not free, you must end an event before starting a new one");
            return;
        }

        int eventIdx = 0;
        int homeTeamIdx = 0;
        int awayTeamIdx = 0;

        boolean isValidInput = false;

        do {
            System.out.println("Events");
            System.out.println();
            System.out.println("Id  Name");
            System.out.println("--  -----------");
            for (int i = 0; i < freeEvents.length; i++)
                System.out.printf("%-2d  %-11s\n", (i+1), freeEvents[i].getName());
            System.out.println();
            System.out.print("Enter Event to begin:  ");

            try {
                eventIdx = Integer.parseInt(input.readLine());
                if(eventIdx >= 1 && eventIdx <= freeEvents.length)
                    isValidInput = true;
            } catch(NumberFormatException nfe) {}

            if(!isValidInput)
                System.out.println("Input must be a number between 1 and " + freeEvents.length);
        } while(!isValidInput);

        isValidInput = false;

        do {
            System.out.println("Teams");
            System.out.println();
            System.out.println("Id  Name");
            System.out.println("--  --------------------");
            for (int i = 0; i < freeTeams.length; i++)
                System.out.printf("%-2d  %-20s\n", i+1, freeTeams[i]);
            System.out.print("Enter home team:  ");

            try {
                homeTeamIdx = Integer.parseInt(input.readLine());
                if(homeTeamIdx >= 1 && homeTeamIdx <= freeTeams.length) {
                    System.out.print("Enter away team:  ");
                    awayTeamIdx = Integer.parseInt(input.readLine());

                    if(awayTeamIdx >= 1 && awayTeamIdx <= freeTeams.length && awayTeamIdx != homeTeamIdx)
                        isValidInput = true;
                }
            } catch(NumberFormatException nfe) {}

            if(!isValidInput)
                System.out.println("Input must be a number between 1 and " + freeTeams.length);
        } while(!isValidInput);

        cm.startCompetition(freeEvents[eventIdx-1], freeTeams[homeTeamIdx-1], freeTeams[awayTeamIdx-1]);
    }

    /**
     * End an existing competition
     *
     * @throws IOException
     */
   /* private void endCompetition() throws IOException
    {
        System.out.println("Lawn Game Olympics End Competition");
        System.out.println();

        ICompetition[] competitions = cm.getCompetitions();

        if(competitions.length == 0)
        {
            System.out.println("No current competitions");
            return;
        }

        int compIdx = 0;
        int winningTeamIdx = 0;

        boolean isValidInput = false;

        do {
            System.out.println("Current Competitions:");
            System.out.println();
            System.out.println("Id  Event       Competition");
            System.out.println("--  ----------  ------------------------------");
            for (int i = 0; i < competitions.length; i++)
                System.out.printf("%-2d  %-11s  %-30s\n", i+1, competitions[i].getEvent().getName(), competitions[i].getHomeTeam() + " vs " + competitions[i].getAwayTeam());
            System.out.print("Enter competition to end:  ");

            try {
                compIdx = Integer.parseInt(input.readLine());
                if (compIdx >= 1 && compIdx <= competitions.length)
                    isValidInput = true;
            }catch(NumberFormatException nfe) {}

            if(!isValidInput)
                System.out.println("Input must be a number between 1 and " + competitions.length);
        } while(!isValidInput);

        ICompetition competition = cm.getCompetitions()[compIdx-1];

        isValidInput = false;
        do {
            System.out.println("Teams:");
            System.out.println();
            System.out.println("Id  Team");
            System.out.println("--  --------------------");
            System.out.println(" 1  " + competition.getHomeTeam());
            System.out.println(" 2  " + competition.getAwayTeam());
            System.out.println();
            System.out.print("Enter Team that won:  ");
            try {
                winningTeamIdx = Integer.parseInt(input.readLine());
                if(winningTeamIdx == 1 || winningTeamIdx == 2)
                    isValidInput = true;
            }catch (NumberFormatException nfe) { }

            if(!isValidInput)
                System.out.println("Input must be 1 or 2");
        } while(!isValidInput);

        Team winningTeam = (winningTeamIdx == 1 ? competition.getHomeTeam() : competition.getAwayTeam());
        cm.endCompetition(competition, winningTeam);
    }
    */


    /**
     * Display the help screen
     */
    private void help()
    {
        System.out.println("Lawn Game Olympics Help");
        System.out.println();
        System.out.println("C   Long Command      Description");
        System.out.println("--  ----------------  -------------------------------------------");
        System.out.println("o   olympians         List the olympians in the system");
        System.out.println("e   events            List the events in the system");
        System.out.println("t   teams             List the teams in the system");
        //System.out.println("c   competitions      List the current competitions in the system");
        System.out.println("sc  startcompetition  Start a new competition");
        //System.out.println("ec  endcompetition    End a currently running competition");
        System.out.println("h   help              Show this help screen");
        System.out.println("q   quit              Quit the program");
    }
    
   
    /**
     * The main entry point to the application
     *
     * @param args the arguments supplied by the user. One argument is expected, the path to the lgoo file.
     */
    public static void main(String[] args) {
    	
    	
    	//initializeQueue();
    	
    	/*QueueItemList q = new QueueItemList();
        q.createQueue(tm.getTeams());
        q.dequeue();*/
      
	    if(args.length != 1)
        {
            System.out.println("Invalid number of arguments, format is: java edu.marist.cmpt220l.Main <lgoo_file>");
            return;
        }

        Main main = new Main(args[0]);
        main.Run();
    }

    private static final int MAGIC_KEY = 522345;
    
    /**
     * Here is where I create a queue that contains every team
     */
    
    /*public static void initilializeQueue(Team[] t){
    	QueueItemList q = new QueueItemList();
    	//set every spot in teamArrayList to a position in the Queue
    	/*for(int i = 0; i > teamArryList.length(); i++){
    	q.enqueue(teamArrayList[i]);
    	}
    	q.enqueue(t.getTeams());
    }*/
}
