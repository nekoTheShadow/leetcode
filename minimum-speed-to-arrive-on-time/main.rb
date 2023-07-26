# @param {Integer[]} dist
# @param {Float} hour
# @return {Integer}
def min_speed_on_time(dist, hour)
    ng = 0
    ok = 10**7+1
    n = dist.size
    while (ng-ok).abs > 1
        mi = (ng+ok)/2

        sum = 0.0
        (0...n).each do |i|
            if i == n-1
                sum += dist[i].to_f / mi
            else
                sum += dist[i]%mi==0 ? dist[i]/mi : dist[i]/mi+1
            end
        end

        if sum <= hour
            ok = mi
        else
            ng = mi
        end
    end
    ok == 10**7+1 ? -1 : ok
end
