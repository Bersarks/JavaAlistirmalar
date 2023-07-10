package Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import model.Award;
import model.AwardCategoryEnum;
import model.AwardTypeEnum;
import model.Team;

public class TeamService {
	public Team createTeam(String name, String nickName, String colors, String coach, String president, String stadium,
						   BigDecimal budget, String currency) {
		Team newTeam = new Team(name, nickName, colors, coach, president, stadium, budget, currency);
		return newTeam;
	}

	public void addAward(Team team, String name, AwardCategoryEnum category, AwardTypeEnum type, int year) {
		Award award = new Award(name, year, type, category);
		if (team.getAwards() != null) {
			team.getAwards().add(award);
		} else {
			List<Award> awardList = new ArrayList<>();
			awardList.add(award);
			team.setAwards(awardList);
		}
	}
}
