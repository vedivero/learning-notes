//문제 설명
//개미 군단이 사냥을 나가려고 합니다.
// 개미군단은 사냥감의 체력에 딱 맞는 병력을 데리고 나가려고 합니다.
// 장군개미는 5의 공격력을, 병정개미는 3의 공격력을 일개미는 1의 공격력을 가지고 있습니다.
// 예를 들어 체력 23의 여치를 사냥하려고 할 때,
// 일개미 23마리를 데리고 가도 되지만,
// 장군개미 네 마리와 병정개미 한 마리를 데리고 간다면 더 적은 병력으로 사냥할 수 있습니다.
// 사냥감의 체력 hp가 매개변수로 주어질 때,
// 사냥감의 체력에 딱 맞게 최소한의 병력을 구성하려면 몇 마리의 개미가 필요한지를 return하도록 solution 함수를 완성해주세요.

// 입출력 예
// hp	 result
// 23	 5
// 24	 6
// 999	 201

class Solution {
    public int solution(int hp) {

        int nowHp = hp;
        int generalAnt = 5;
        int soliderAnt = 3;
        int workingAnt = 1;

        int totalAnt = 0;

        if (hp >= generalAnt) {
            totalAnt += hp / generalAnt;
            nowHp = hp % generalAnt;
        }

        if (nowHp >= soliderAnt) {
            totalAnt += nowHp / soliderAnt;
            nowHp %= soliderAnt;
        }

        if (nowHp >= workingAnt) {
            totalAnt += nowHp / workingAnt;
        }

        return totalAnt;

    }
}
// 연산 후 체력 값을 저장할 변수와 각 개미의 공격력 값을 담은 변수를 선언하고 값을 초기화
// 대상의 체력이 장군 개미의 공격력보다 크거나 같을 경우, 나누기 연산으로 투입할 장군 개미 수를 구함
// 나머지 연산을 통해 장군 개미가 공격 후, 남은 hp를 현재 체력 변수에 저장
// 병정 개미, 일 개미도 동일하게 연산
// *투입 필요한 개미 수를 구한 후, 체력 연산을 처리해야 정확한 수 파악 가능