from typing import List, Set, Dict, Tuple


class Solution:
    def separateSquares(self, squares: List[List[int]]) -> float:
        # 1. x座標の座標圧縮
        x_coords_set: Set[int] = set()
        for x, y, l in squares:
            x_coords_set.add(x)
            x_coords_set.add(x + l)

        sorted_x: List[int] = sorted(list(x_coords_set))
        x_map: Dict[int, int] = {val: i for i, val in enumerate(sorted_x)}
        m: int = len(sorted_x) - 1  # 基本区間の数

        # 2. セグメント木の初期化
        # tree_cnt: その区間が完全に覆われている回数
        # tree_len: そのノードの範囲内で実際に覆われている合計の長さ
        # node_full_len: そのノードが担当する区間の本来の長さ
        tree_cnt: List[int] = [0] * (4 * m)
        tree_len: List[float] = [0.0] * (4 * m)
        node_full_len: List[float] = [0.0] * (4 * m)

        def build(v: int, tl: int, tr: int) -> None:
            node_full_len[v] = float(sorted_x[tr + 1] - sorted_x[tl])
            if tl < tr:
                tm: int = (tl + tr) // 2
                build(2 * v, tl, tm)
                build(2 * v + 1, tm + 1, tr)

        build(1, 0, m - 1)

        def update(v: int, tl: int, tr: int, l: int, r: int, val: int) -> None:
            if l == tl and r == tr:
                tree_cnt[v] += val
            else:
                tm: int = (tl + tr) // 2
                if r <= tm:
                    update(2 * v, tl, tm, l, r, val)
                elif l > tm:
                    update(2 * v + 1, tm + 1, tr, l, r, val)
                else:
                    update(2 * v, tl, tm, l, tm, val)
                    update(2 * v + 1, tm + 1, tr, tm + 1, r, val)

            # 覆われている長さの更新
            if tree_cnt[v] > 0:
                tree_len[v] = node_full_len[v]
            elif tl < tr:
                tree_len[v] = tree_len[2 * v] + tree_len[2 * v + 1]
            else:
                tree_len[v] = 0.0

        # 3. イベントの準備 (y座標でソート)
        events: List[Tuple[int, int, int, int]] = []
        for x, y, l in squares:
            events.append((y, x_map[x], x_map[x + l], 1))
            events.append((y + l, x_map[x], x_map[x + l], -1))

        # yが同じなら、面積計算に影響しないが、最小yを求めるために安定させる
        events.sort()

        # 4. 1回目の走査：全面積の計算と、各y区間の幅を記録
        total_area: float = 0.0
        strips: List[Tuple[float, float, float]] = []

        for i in range(len(events) - 1):
            y_curr, x1_idx, x2_idx, typ = events[i]
            # [x1, x2] の範囲を更新（座標圧縮後のインデックスを用いる）
            update(1, 0, m - 1, x1_idx, x2_idx - 1, typ)

            y_next: int = events[i + 1][0]
            if y_next > y_curr:
                current_width: float = tree_len[1]
                strip_area: float = current_width * (y_next - y_curr)
                total_area += strip_area
                strips.append((float(y_curr), float(y_next), current_width))

        # 5. 2回目の走査：累積面積が半分になる場所を特定
        target_area: float = total_area / 2.0
        accumulated_area: float = 0.0

        for y_start, y_end, width in strips:
            area_in_strip: float = width * (y_end - y_start)
            # 浮動小数点の誤差を考慮し、微小な値を許容するか、あるいは
            # accumulated + area_in_strip が目標を超えた瞬間に計算する
            if accumulated_area + area_in_strip >= target_area - 1e-15:
                if width == 0:
                    return y_start
                needed_area: float = target_area - accumulated_area
                return y_start + (needed_area / width)
            accumulated_area += area_in_strip

        return float(events[-1][0])
