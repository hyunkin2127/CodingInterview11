package algorithm;

/** 문제해결능력 기르기 프린트 두번째 문제
 * HitCounter 개선하기
 * Created by Heon on 2015-10-28.
 */
public class hitCounter {

	public hitCounter(){}

	class Point2D{
		public int x;
		public int y;

		public Point2D(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public boolean isCrashed(Point2D[] pNPC, Point2D bullet){

		for(int i=0; i<pNPC.length; i++){
			if(pNPC[i].x == bullet.x && pNPC[i].y == bullet.y)
				return true;
		}
		return false;
	}

	public int getHitCount(Point2D[][] NPCs, Point2D[] bullets){

		int count = 0;

		int top, bottom, left, right;


		for(int i=0; i<NPCs.length; i++){
			top = getSidePoint(NPCs[i], 't');
			bottom = getSidePoint(NPCs[i], 'b');
			left = getSidePoint(NPCs[i], 'l');
			right = getSidePoint(NPCs[i], 'r');


			for(int j=0; j<bullets.length; j++){

				if(bullets[j].x > right || bullets[j].x < left || bullets[j].y > top || bullets[j].y < bottom) continue;;
				if(isCrashed(NPCs[i], bullets[j])) count++;
			}
		}
		return count;
	}

	public int getSidePoint(Point2D[] NPC, char direction){

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		switch(direction){
			case 't':
				for(int i=0; i<NPC.length; i++) if(NPC[i].y > max) max = NPC[i].y;
				return max;

			case 'b':
				for(int i=0; i<NPC.length; i++) if(NPC[i].y < min) min = NPC[i].y;
				return min;

			case 'l':
				for(int i=0; i<NPC.length; i++) if(NPC[i].x < min) min = NPC[i].x;
				return min;
			case 'r':
				for(int i=0; i<NPC.length; i++) if(NPC[i].x > max) max = NPC[i].x;
				return max;
		}

		return 0;

	};

}
