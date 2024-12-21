class Solution:
    def maxKDivisibleComponents(self, n: int, edges: List[List[int]], values: List[int], k: int) -> int:
        from collections import defaultdict
        
        # グラフを作成
        graph = defaultdict(list)
        for a, b in edges:
            graph[a].append(b)
            graph[b].append(a)
        
        self.num_components = 0
        
        # サブツリーの値を計算するためのDFS
        def dfs(node, parent):
            subtree_sum = values[node]  # 現在のノードの値

            for neighbor in graph[node]:
                if neighbor == parent:
                    continue
                child_sum = dfs(neighbor, node)
                if child_sum % k == 0:
                    # 子のサブツリーが割り切れる場合、新しいコンポーネントとしてカウント
                    self.num_components += 1
                else:
                    # 割り切れない場合、現在のノードに値を追加
                    subtree_sum += child_sum
            return subtree_sum

        # DFS をルートノードから開始
        total_sum = dfs(0, -1)
        if total_sum % k == 0:
            self.num_components += 1
        return self.num_components
