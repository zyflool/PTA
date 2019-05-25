/*
1015 德才论 (25 分)
宋代史学家司马光在《资治通鉴》中有一段著名的“德才论”：
“是故才德全尽谓之圣人，才德兼亡谓之愚人，德胜才谓之君子，才胜德谓之小人。凡取人之术，苟不得圣人，君子而与之，与其得小人，不若得愚人。”
现给出一批考生的德才分数，请根据司马光的理论给出录取排名。

输入格式：
输入第一行给出 3 个正整数，分别为：
N（≤10^5），即考生总数；
L（≥60），为录取最低分数线，即德分和才分均不低于 L 的考生才有资格被考虑录取；
H（<100），为优先录取线——德分和才分均不低于此线的被定义为“才德全尽”，此类考生按德才总分从高到低排序；
才分不到但德分到线的一类考生属于“德胜才”，也按总分排序，但排在第一类考生之后；
德才分均低于 H，但是德分不低于才分的考生属于“才德兼亡”但尚有“德胜才”者，按总分排序，但排在第二类考生之后；
其他达到最低线 L 的考生也按总分排序，但排在第三类考生之后。
随后 N 行，每行给出一位考生的信息，包括：
准考证号 德分 才分，其中准考证号为 8 位整数，德才分为区间 [0, 100] 内的整数。数字间以空格分隔。

输出格式：
输出第一行首先给出达到最低分数线的考生人数 M，
随后 M 行，每行按照输入格式输出一位考生的信息，考生按输入中说明的规则从高到低排序。
当某类考生中有多人总分相同时，按其德分降序排列；若德分也并列，则按准考证号的升序输出。

输入样例：
14 60 80
10000001 64 90
10000002 90 60
10000011 85 80
10000003 85 80
10000004 80 85
10000005 82 77
10000006 83 76
10000007 90 78
10000008 75 79
10000009 59 90
10000010 88 45
10000012 80 100
10000013 90 99
10000014 66 60
输出样例：
12
10000013 90 99
10000012 80 100
10000003 85 80
10000011 85 80
10000004 80 85
10000007 90 78
10000006 83 76
10000005 82 77
10000002 90 60
10000014 66 60
10000008 75 79
10000001 64 90
 */
#include <stdio.h>
#include <stdlib.h>

typedef struct _Student{
    int ID;
    int D;      /** de2 : virtue  */
    int C;      /** cai2: ability */
    int rank;
    int sum;    /** sum = D + C   */
}sStudent, *Student;

/* larger the number, higher the rank */
int rank(Student s, int H, int L)
{
    if(s->D < L || s->C < L)        return 0;   /* failed */
    else if(s->D >= H && s->C >= H) return 4;   /* best */
    else if(s->D >= H)              return 3;   /* second */
    else if(s->D >= s->C)           return 2;   /* third */
    else                            return 1;   /* fourth */
}

int comp(const void *a, const void *b)
{
    Student s1 = *(Student*)a;
    Student s2 = *(Student*)b;

    if(s1->rank != s2->rank)    return s1->rank - s2->rank;
    else if(s1->sum != s2->sum) return s1->sum - s2->sum;
    else if(s1->D != s2->D)     return s1->D - s2->D;
    else if(s1->ID != s2->ID)   return s2->ID - s1->ID;
    else                        return 0;
}

int main()
{
    int N, L, H, M = 0;
    Student students[100000] = {0};
    sStudent buffer[100000];

    scanf("%d %d %d", &N, &L, &H);
    for(int i = 0; i < N; i++)
    {
        Student s = buffer + i;
        scanf("%d %d %d", &s->ID, &s->D, &s->C);
        s->sum = s->D + s->C;
        if((s->rank = rank(s, H, L)) != 0) /* record if passed */
            students[M++] = s;
    }

    qsort(students, M, sizeof(Student), comp);

    printf("%d\n", M);
    for(int i = M - 1; i >= 0; i--)
        printf("%d %d %d\n", students[i]->ID, students[i]->D, students[i]->C);

    return 0;
}
