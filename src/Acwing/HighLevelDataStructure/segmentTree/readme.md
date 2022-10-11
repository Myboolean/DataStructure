# 线段树
- 是一个二叉树除了最后一层结点之外的都是满的，
### 操作
- pushUp() 
- pushDown()  lay标记和delay标记
### pushUp
- build() 将一段区间初始化成线段树
- modify() 修改
  - 单点 easy
  - 区间 pushDown 懒标记  延迟标记
- query() 的时间复杂度是在O(log n)
#### 取最大值
- [L , R] 属于[TL, TR] 直接返回最大值
- [L, R] 和[TL, TR]有交集，取所有交集区间的的最大值
#### 求和
- [L , R] 属于[TL, TR] 一直递归到TL - TMID - TR刚好是L和R的位置的和
- [L, R] 和[TL, TR]有交集，分别取所有有交集的区间的和