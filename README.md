# A game of dice

Alice proposes a game to Bob.

On the table are 3 dice with 6 sides each, and labels of the numbers 1 through 18. Player X gets to arrange the labels on the dice, after which player Y gets the first pick.

In each of the ten rounds that follow, each player will cast their die. The player with the highest roll wins the round. The player who wins most rounds wins the game.

Should Bob be player X or player Y?

## Solution

### Conditions under which Bob volunteers to be player X

Player X only has an advantage if she can choose a die that beats player Y's pick regardless of Y's pick.

Such a property may colloquially be referred to as a Rock-Paper-Scissors property. For Rock-Paper-Scissors, Paper beats Rock, Scissors beats Paper, and Rock beats Scissors. Regardless of the choice, there exists another choice that beats it. Mathematicians refer to such a property as nontransitive or intransitive.

For dice we say A beats B if A results in a higher roll than B more than half the time. Bob should only choose to be player X if he is able to arrange the labels on the dice such that die A beats B, B beats C, and C beats A.

### Dice arrangements

It comes as a surprise to many that a nontransitive configuration is not just possible, but 10,705 such arrangements exist. To enumerate all solutions, run `ApplicationDice.kt` in the `dice` package. Twenty solutions are presented below.

| #  | A  | B  | C  | p(A) > p(B) | p(B) > p(C) | p(C) > p(A) |
|---|---|---|---|---|---|---|
1 | 1, 10, 11, 12, 13, 14 | 5, 6, 7, 8, 9, 18 | 2, 3, 4, 15, 16, 17 | 0.6945 | 0.5834 | 0.5834 |
2 | 1, 9, 11, 12, 13, 14 | 5, 6, 7, 8, 10, 18 | 2, 3, 4, 15, 16, 17 | 0.6667 | 0.5834 | 0.5834 |
3 | 1, 8, 11, 12, 13, 14 | 5, 6, 7, 9, 10, 18 | 2, 3, 4, 15, 16, 17 | 0.6389 | 0.5834 | 0.5834 |
4 | 1, 9, 10, 12, 13, 14 | 5, 6, 7, 8, 11, 18 | 2, 3, 4, 15, 16, 17 | 0.6389 | 0.5834 | 0.5834 |
5 | 1, 7, 11, 12, 13, 14 | 5, 6, 8, 9, 10, 18 | 2, 3, 4, 15, 16, 17 | 0.6112 | 0.5834 | 0.5834 |
6 | 1, 8, 10, 12, 13, 14 | 5, 6, 7, 9, 11, 18 | 2, 3, 4, 15, 16, 17 | 0.6112 | 0.5834 | 0.5834 |
7 | 1, 9, 10, 11, 13, 14 | 5, 6, 7, 8, 12, 18 | 2, 3, 4, 15, 16, 17 | 0.6112 | 0.5834 | 0.5834 |
8 | 1, 6, 7, 8, 17, 18 | 3, 4, 5, 14, 15, 16 | 2, 9, 10, 11, 12, 13 | 0.5834 | 0.5834 | 0.5834 |
9 | 1, 2, 11, 12, 13, 18 | 6, 7, 8, 9, 10, 17 | 3, 4, 5, 14, 15, 16 | 0.5834 | 0.5834 | 0.5834 |
10 | 1, 6, 11, 12, 13, 14 | 5, 7, 8, 9, 10, 18 | 2, 3, 4, 15, 16, 17 | 0.5834 | 0.5834 | 0.5834 |
11 | 1, 7, 10, 12, 13, 14 | 5, 6, 8, 9, 11, 18 | 2, 3, 4, 15, 16, 17 | 0.5834 | 0.5834 | 0.5834 |
12 | 1, 8, 9, 12, 13, 14 | 5, 6, 7, 10, 11, 18 | 2, 3, 4, 15, 16, 17 | 0.5834 | 0.5834 | 0.5834 |
13 | 1, 8, 10, 11, 13, 14 | 5, 6, 7, 9, 12, 18 | 2, 3, 4, 15, 16, 17 | 0.5834 | 0.5834 | 0.5834 |
14 | 1, 9, 10, 11, 12, 14 | 5, 6, 7, 8, 13, 18 | 2, 3, 4, 15, 16, 17 | 0.5834 | 0.5834 | 0.5834 |
15 | 1, 2, 9, 14, 15, 16 | 6, 7, 8, 11, 12, 13 | 3, 4, 5, 10, 17, 18 | 0.5834 | 0.5834 | 0.5834 |
16 | 1, 8, 9, 10, 11, 12 | 4, 5, 6, 7, 17, 18 | 2, 3, 13, 14, 15, 16 | 0.5556 | 0.5556 | 0.7223 |
17 | 1, 2, 12, 13, 14, 15 | 7, 8, 9, 10, 11, 18 | 3, 4, 5, 6, 16, 17 | 0.5556 | 0.7223 | 0.5556 |
18 | 1, 8, 9, 10, 11, 13 | 4, 5, 6, 7, 17, 18 | 2, 3, 12, 14, 15, 16 | 0.5556 | 0.5556 | 0.6945 |
19 | 1, 2, 12, 13, 14, 15 | 6, 8, 9, 10, 11, 18 | 3, 4, 5, 7, 16, 17 | 0.5556 | 0.6945 | 0.5556 |
20 | 1, 10, 11, 12, 13, 15 | 4, 6, 7, 8, 9, 18 | 2, 3, 5, 14, 16, 17 | 0.6945 | 0.5556 | 0.5556 |

Even though any nontransitive set gives Bob an advantage, some nontransitive sets are preferable over others.

Consider first that Alice is likely aware of the crux of the problem, and will pick the die that gives Bob the least advantage. Bob therefore prefers solutions that ensure that the least dominant of the three pairs is as high as possible. For the top 15 solutions this probability equals 21/36, or 0.5834.

Consider also that Alice may assume Bob's edge is the same regardless of which die she chooses. Note that the top 7 solutions include one die that is dominated to a much larger extent. Alice may inadvertently choose this die, so it is in Bob's interest for this wildcard choice to be as advantageous as possible.

The solutions above are ranked first according to the greatest least dominant pair, and then according to the greatest wildcard edge.

### Bob's chances of winning

Bob arranges the dice according to solution 1. Alice chooses die C, leading Bob to choose die B. How likely is he to win?

Bob's chance of winning more than 5 rounds is 0.5908, while Alice's chance of winning more than 5 rounds is 0.1954. The chance of both players winning exactly 5 rounds is 0.2138. These probabilities can be computed using a binomial distribution.

## Problem history

Nontransitive dice were popularized by Martin Gardner in his Scientific American column [1]. The problem described above is similar to the problem outlined in the introduction of a paper by Richard Savage [2].

Many more examples of nontransitive dice exist.

## Implementation notes

The above solution is found through enumeration. Note that despite the approach below, this only works for comparatively small problems.

At first glance it may be tempting to take the 18 labels, create all possible permutations, and assign positions 1 through 6 to group/die A, 6 through 12 to B, and the remainder to C. Note however that 18! (factorial) such permutations exist, a huge number. Such a strategy generates many duplicate solutions where the label order within a group differs.

It is sufficient to enumerate the number of possible groupings, known as combinations. The number of unique possible arrangements equals (18 over 6) * (12 over 6) * (6 over 6), or 17,153,136. To generate this, create an array of size 18 with six entries of 0, 1 and 2. These represent group/die assignments. This set contains duplicate entries, and is referred to as a multiset, which can be permutated efficiently using specialized algorithms [3]. By using each permutation as an overlay/mask for the labels, each possible grouping is generated without regard for the group-internal label order.

The number of solutions can be further reduced by a factor of three. A solution A > B > C > A is equivalent to one where the labels are shifted by one or two positions (such that B takes the place of A, etcetera). To prevent this, anchor the first element to always be in group/die A. This leaves 5,717,712 possible solutions to be evaluated.

## See

[1] Gardner, M. (1970). The paradox of the nontransitive dice. Scientific American, 223 (Dec. 1970) 110–111.

[2] Savage, R. P. (1994). The Paradox of Nontransitive Dice. The American Mathematical Monthly, 101(5), 429.

[3] Williams, A. (2008). Loopless generation of multiset permutations using a constant number of variables by prefix shifts. SODA '09 Proceedings of the 20th annual ACM-SIAM symposium on Discrete algorithms, 987-996.
