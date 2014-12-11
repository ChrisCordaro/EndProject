package Teams;


import java.util.ArrayList;
import java.util.Random;

import Main.Sex;
import Olympians.Olympian;
import Olympians.OlympianManager;

/**
 * A TeamManager manages instances of teams
 */
public class TeamManager {
    private Team[] teams;

    /**
     * Construct a new TeamManager object.
     *
     * @param om The olympian manager which provides the olympians to create teams from
     */
    public TeamManager(OlympianManager om)
    {
        Random random = new Random();

        //two lists, one for all the males and one for all the females
        ArrayList maleOlympians = new ArrayList();
        ArrayList femaleOlympians = new ArrayList();

        Olympian[] olympians = om.getOlympians();

        //go through all the olympians and separate them by sex
        for(int i=0; i < olympians.length; i++)
        {
            if(olympians[i].getSex() == Sex.MALE)
                maleOlympians.add(olympians[i]);
            else
                femaleOlympians.add(olympians[i]);
        }

        //create teams from both sexes until we run out of males or females
        ArrayList teamArrayList = new ArrayList();
        while(maleOlympians.size() > 0 && femaleOlympians.size() > 0)
        {
            Olympian maleOlympian = (Olympian)maleOlympians.remove(random.nextInt(maleOlympians.size()));
            Olympian femaleOlympian = (Olympian)femaleOlympians.remove(random.nextInt(femaleOlympians.size()));

            teamArrayList.add(new Team(maleOlympian, femaleOlympian));
        }

        //take any remaining males and put them together (may be none)
        while(maleOlympians.size() > 1)
        {
            Olympian male1Olympian = (Olympian)maleOlympians.remove(random.nextInt(maleOlympians.size()));
            Olympian male2Olympian = (Olympian)maleOlympians.remove(random.nextInt(maleOlympians.size()));

            teamArrayList.add(new Team(male1Olympian, male2Olympian));
        }

        //take any remaining females and put them together (may be none)
        while(femaleOlympians.size() > 1)
        {
            Olympian female1Olympian = (Olympian)maleOlympians.remove(random.nextInt(femaleOlympians.size()));
            Olympian female2Olympian = (Olympian)maleOlympians.remove(random.nextInt(femaleOlympians.size()));

            teamArrayList.add(new Team(female1Olympian, female2Olympian));
        }

        //copy the team list to a team array
        teams = new Team[teamArrayList.size()];
        for(int i=0; i < teams.length; i++)
            teams[i] = (Team)teamArrayList.get(i);
    }

    /**
     * Retrieve the teams
     *
     * @return the teams
     */
    public Team[] getTeams()
    {
        return teams;
    }
    
    public Team getSingleTeam(int i){
    	return teams[i];
    }
}
