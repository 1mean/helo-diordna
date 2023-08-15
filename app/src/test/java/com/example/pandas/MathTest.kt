package com.example.pandas

import org.junit.Test

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 8/10/23 12:19 AM
 * @version: v1.0
 */
public class MathTest {

    @Test
    fun `test math reverse integer`() {
        println(romanToInt("MCMXCIV"))
    }

    private fun romanToInt(s: String): Int {
        val map: MutableMap<Char, Int> = HashMap()
        map['I'] = 1
        map['V'] = 5
        map['X'] = 10
        map['L'] = 50
        map['C'] = 100
        map['D'] = 500
        map['M'] = 1000
        val len = s.length
        println("len:$len")
        val slen = s[len - 1]
        println("slen: $slen")
        var sum = map[s[len - 1]]!!
        println("sum: $sum")
        for (i in len - 2 downTo 0) {
            if (map[s[i]]!! < map[s[i + 1]]!!) {
                sum -= map[s[i]]!!
            } else {
                sum += map[s[i]]!!
            }
        }
        return sum
    }

    private fun isPalindrome(x: Int): Boolean {
        var x = x
        if (x < 0 || x != 0 && x % 10 == 0) return false
        var halfReverseX = 0
        while (x > halfReverseX) {
            halfReverseX = halfReverseX * 10 + x % 10
            println("halfReverseX:$halfReverseX")
            x /= 10
            println("x:$x")
        }
        return halfReverseX == x || halfReverseX / 10 == x
    }

    private fun reverse(x: Int): Int {
        var y = x
        var res: Long = 0
        while (y != 0) {
            res = res * 10 + y % 10
            println("res:$res")
            y /= 10
            println("y:$y")
        }
        println("finally res:$res")
        return if (res > Int.MAX_VALUE || res < Int.MIN_VALUE) 0 else res.toInt()
    }

    public class ListNode(val node: Int) {
        var next: ListNode? = null
    }


    @Test
    fun `test merge two list`() {
        var l1 = ListNode(1)
        val l3 = ListNode(5)
        l1.next = l3
        val l4 = ListNode(6)
        l3.next = l4

        var l2 = ListNode(3)
        val l5 = ListNode(4)
        l2.next = l5
        val l6 = ListNode(5)
        l6.next = l5

        var l1_flag = true
        var l2_flag = true

        /**
         * 1->5->6
         * 3->4->5
         */
        val list = arrayListOf<Int>()
        var resultNode = ListNode(0)
        var temp = resultNode
        while (l2_flag || l1_flag) {
            if (l1.node < l2.node) {
                temp.next = l1
                if (l1.next == null) {
                    l1_flag = false
                } else {
                    l1 = l1.next!!
                }
            } else {
                temp.next = l2
                if (l2.next == null) {
                    l2_flag = false
                } else {
                    l2 = l2.next!!
                }
            }
            temp.next?.let {
                temp = it
                list.add(temp.node)
            }
        }
        println("list:$list")
    }

    @Test
    fun `my qrt`() {
        val x = 8
        var n = x.toLong()
        while (n * n > x) {
            n = n + x / n shr 1
            println("n=$n")
        }
    }
}