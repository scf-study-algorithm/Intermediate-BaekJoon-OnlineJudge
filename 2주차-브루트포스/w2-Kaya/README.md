# BaekJoon-OnlineJudge 2주차

## 1759 암호 만들기

조합을 구현하면 편하게 풀 수 있는데 구현할 줄 몰랐다..

직접 구현하려고 해봤는데 뽑아야 하는 문자의 개수가 달라서 방법을 생각해내기가 힘들었다.

조합을 쉽게 구하는 방법은 itertools 라이브러리의 combinations를 사용하면 된다.

<pre><code>
import itertools

nCr = list(itertools.combinations('뽑아 낼 대상', '뽑을 개수'))
</code></pre>

결국 검색을 통해 이 방법을 알아내었다...

다른 방법으로는 재귀를 이용하면 조합을 구할 수 있다고 한다.

<pre><code>
def gen_combinations(arr, n): 
    result =[] 
    
    if n == 0: 
        return [[]] 
        
    for i in range(0, len(arr)): 
        elem = arr[i] 
        rest_arr = arr[i + 1:] 
        for C in gen_combinations(rest_arr, n-1): 
            result.append([elem]+C) 
    
    return result

</code></pre>

아직 무슨 말인지 모르겠다..

출처: https://cotak.tistory.com/70 [TaxFree]
