import random
from collections import Counter
from typing import List, Tuple

from django.contrib.admin import action

# ====================
# 数据定义层
# ====================
DICE_DATA = {
    '普通骰子': [17, 17, 17, 17, 17, 17],
    '灌铅骰子': [67, 7, 7, 7, 7, 7],
    '恶魔骰子': [17, 17, 17, 17, 17, 17],
}

SCORE_RULES = {
    'straight': {
        (1, 2, 3, 4, 5): 500,
        (2, 3, 4, 5, 6): 750,
        (1, 2, 3, 4, 5, 6): 1500
    }
}


# ====================
# 核心逻辑层
# ====================
class Dice:
    def __init__(self, name: str):
        self.name = name
        self.weights = [w / sum(DICE_DATA[name]) for w in DICE_DATA[name]]

    def roll(self) -> int:
        return random.choices(range(1, 7), weights=self.weights)[0]


class ScoreValidator:
    @staticmethod
    def validate_selection(dice_values: List[int], selected: List[int]) -> int:
        score = 0
        selected_values = [dice_values[i] for i in selected]
        counter = Counter(selected_values)
        used = set()

        # 顺子检测
        if len(selected) >= 5:
            sorted_values = sorted(selected_values)
            for pattern in [(1, 2, 3, 4, 5), (2, 3, 4, 5, 6)]:
                if sorted_values[:5] == list(pattern):
                    score += SCORE_RULES['straight'][pattern]
                    used.update([pattern[0], pattern[1], pattern[2], pattern[3], pattern[4]])
            if sorted_values == [1, 2, 3, 4, 5, 6]:
                return 1500

        # 组合得分（按数量降序处理）
        for num in sorted(counter, key=lambda x: -counter[x]):
            count = counter[num]
            if count < 3 or num in used:
                continue

            base = 1000 if num == 1 else num * 100
            multiplier = 1 << (count - 3)  # 使用位运算替代2**n
            #multiplier = 2 ** (count - 3)
            score += base * multiplier
            used.add(num)

            # 标记已用骰子
            indices = [i for i, v in enumerate(dice_values) if v == num]
            used.update(indices[:count])

        # 单骰得分
        for i in selected:
            val = dice_values[i]
            if val in [1, 5] and i not in used:
                score += 100 if val == 1 else 50

        return score if score > 0 else 0

class Player:
    def __init__(self, name: str):
        self.name = name
        self.total_score = 0
        self.dice_set = [
            Dice('普通骰子'),
            Dice('普通骰子'),
            Dice('恶魔骰子'),
            Dice('灌铅骰子'),
            Dice('普通骰子'),
            Dice('普通骰子')
        ]
# ====================
# 游戏流程层
# ====================
class GameEngine:
    def __init__(self, players: List[str], target: int = 5000):
        self.players = [Player(name) for name in players]
        self.target = target

    def start(self):
        current_player = 0
        while True:
            player = self.players[current_player]
            print(f"\n=== {player.name}的回合 ===")

            turn_score = self._run_turn(player)
            player.total_score += turn_score

            if player.total_score >= self.target:
                print(f"{player.name} 获胜！")
                break

            current_player = (current_player + 1) % len(self.players)

    def _run_turn(self, player: Player) -> int:

        score = 0
        remaining_dice = 6
        action = "y"
        while True:
            roll = bool(True if action == 'y' else False)
            # 投掷骰子
            if roll:
                dice_results = [d.roll() for d in player.dice_set[:remaining_dice]]
            print(f"\n骰子结果: {dice_results}")

            # 选择骰子
            selected = self._select_scoring_dice(dice_results)
            if not selected :
                print("必须选择至少一个骰子！")
                action = 'n'
                continue

            # 计算得分
            turn_score = ScoreValidator.validate_selection(dice_results, selected)
            #turn_score = selected[1]
            if turn_score == 0:
                print("无效选择，得分清零！")
                action = 'n'
                return 0


            remaining_dice -= len(selected)

            # 重置骰子
            if remaining_dice == 0:
                remaining_dice = 6

            # 决策是否继续
            print(f"本轮得分: {turn_score} | 累计得分: {score} | 剩余骰子: {remaining_dice}")
            action = input("继续投掷？(y/n): ").lower()
            if action != 'y':
                return score
            if action == 'n':
                score += turn_score
                return score
    def _select_scoring_dice(self, dice_values: List[int]) -> List[int]:
        print(f"\n骰子结果: {' '.join(map(str, dice_values))}")
        while True:
            try:
                choices = input("选择要保留的骰子数值（空格分隔）: ").split()
                selected_values = [int(v) for v in choices]

                # 获取所有可能索引
                temp = dice_values.copy()
                selected_indices = []
                for val in selected_values:
                    available = [i for i, v in enumerate(temp) if v == val]
                    if not available:
                        raise ValueError
                    selected_indices.append(available[0])
                    temp[available[0]] = None  # 标记已选

                return sorted(selected_indices)
            except:
                print("输入包含无效骰子，请重新选择")




# ====================
# 运行测试
# ====================
if __name__ == "__main__":
    print("=== 天国拯救骰子游戏 ===")
    players = input("输入玩家名称（用空格分隔）: ").split()
    game = GameEngine(players, target=300)
    game.start()
