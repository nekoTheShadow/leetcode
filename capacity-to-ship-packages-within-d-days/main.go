package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(shipWithinDays([]int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5))
	fmt.Println(shipWithinDays([]int{3, 2, 2, 4, 1, 4}, 3))
	fmt.Println(shipWithinDays([]int{1, 2, 3, 1, 1}, 4))
}

func shipWithinDays(weights []int, days int) int {
	total := 0
	for _, weight := range weights {
		total += weight
	}

	return sort.Search(total+1, func(x int) bool {
		sum := 0
		count := 0
		for _, weight := range weights {
			if x < weight {
				return false
			}

			if sum+weight <= x {
				sum += weight
			} else {
				sum = weight
				count++
			}
		}

		return count+1 <= days
	})
}

// 本問題を解くにあたって、もっとも単純なアルゴリズムは以下のとおりである。

// 1. weightsをdays個に分割し、分割結果から必要なサイズの船を割り出す
// 2. 1.をすべての組み合わせで試してみて、最小の船のサイズを求める。

// このアルゴリズムの計算量はO(2^N)になる(自信なし)ため、Nが大きくなると、制限時間内では完了しない。
// したがって、アルゴリズムに工夫が必要になる。

// サイズがxの船を用意したとき
// ・days日以下ですべての荷物を運ぶことができたらOK
// ・days日かかってもすべての荷物を運ぶことができなかったらNG

// 特大サイズの船を用意する(=xに大きな値を設定する)と、明らかにすべての荷物をdays日以下で運ぶことができる。
// そのあと、船のサイズを小さくしていく(=xの値を小さくする)と、days以下ですべての荷物が運べるかどうかがぎりぎりになっていき、
// あるしきい値を超えると、days日ではすべての荷物を運べなくなる。
// 今回の問題では、このしきい値を求めればよい。

// |<---NG--->|<---OK--->|
// -----------------------> x

// 整列されたデータにおいて、ある1点を境目に条件を満たすエリアと条件を満たさないエリアに分けられており、
// その境目を探す場合、二分探索が有効である。計算量はO(logN)。

// なお、あるサイズの船を用意したときにdays日以下ですべての荷物を運べるか否かについては、
// これは「荷物を載せれるだけ載せる。載せられなくなったら、次の日の船にまわす」というロジックで判定可能。
// 貪欲法とよばれるアルゴリズムで、今回の場合の計算量はO(logN)。

// したがって計算量の全体はO(NlogN)となり、今回のNの制約下であれば、制限時間内で完了する。
