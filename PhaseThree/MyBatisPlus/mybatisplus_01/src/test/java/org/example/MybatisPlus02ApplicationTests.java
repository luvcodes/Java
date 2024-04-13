package org.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.domain.Member;
import org.example.domain.User;
import org.example.mapper.MemberMapper;
import org.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MybatisPlus02ApplicationTests {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testSave() {
        Member member = new Member();
        member.setUsername("Member02");
        member.setEmail("member02@gmail.com");
        member.setJoinedAt(Long.valueOf("20240413111129"));

        memberMapper.insert(member);
    }

    @Test
    public void testDeleteById() {
        memberMapper.deleteById(4);
    }

    /**
     * 批量删除
     * */
    @Test
    public void testDeleteIds() {
        // ArrayList删除第一种方法
        /*ArrayList<Integer> listIds = new ArrayList<>();
        listIds.add(2);
        listIds.add(3);*/

        // 第二种方法
         List<Integer> listIds = Arrays.asList(2, 3);
         memberMapper.deleteBatchIds(listIds);
    }

    /**
     * 根据id更新member信息
     * */
    @Test
    public void testUpdate() {
        Member member = new Member();
        member.setId(5);
        member.setUsername("updateUsername");

        memberMapper.updateById(member);
    }

    @Test
    public void testGet() {
        Member member = memberMapper.selectById(1);
        System.out.println(member);
    }

    @Test
    public void testGetAll() {
        // 方法一
        /*List<Member> members = memberMapper.selectList(null);
        System.out.println(members);*/

        // 方法二
        /*ArrayList<Integer> listIds = new ArrayList<>();
        listIds.add(1);
        listIds.add(2);
        listIds.add(3);
        memberMapper.selectBatchIds(listIds);*/

        // 方法三
        List<Integer> listIds = Arrays.asList(1,2,3);
        memberMapper.selectBatchIds(listIds);
    }

    @Test
    void testGetByPage() {
        IPage page = new Page(1, 2);
        memberMapper.selectPage(page, null);
        System.out.println("Current page number: " + page.getCurrent());
        System.out.println("Current page size: " + page.getSize());
        System.out.println("Total page number: " + page.getPages());
        System.out.println("Total record number: " + page.getTotal());
        System.out.println("================================================");
        System.out.println("Get the specific records: " + page.getRecords());
    }
}
