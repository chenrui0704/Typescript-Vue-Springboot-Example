<style>

</style>
<template>
    <div>
        <Menu style="width: 100%;height: calc(100vh - 50px)">
            <template v-for="(item,index) in menuList">
                <MenuItem :name="index" :to="item.children[0].name" v-if="item.children.length == 1 " >
                    <Icon type="ios-paper" />
                    {{item.title}}
                </MenuItem>
                <Submenu :name="index"    v-if="item.children.length > 1">
                    <template slot="title">
                        <Icon type="ios-people" />
                        {{item.title}}
                    </template>
                    <template v-for="(child,childIndex) in item.children">
                        <MenuItem :name="index + '-'+childIndex" :to="child.name">{{child.title}}</MenuItem>
                    </template>
                </Submenu>
            </template>
        </Menu>
    </div>
</template>

<script lang="ts">
    import { Component, Vue } from 'vue-property-decorator';

    @Component
    export default class Menus extends Vue{

        menuList:any = [];

        created() {
            let role = Number(JSON.parse(this.$Cookies.get('userinfo')).role);
            this.$MenuList.forEach(x => { x.role.includes(role) ? this.menuList.push(x) : null; });
        }

    }

</script>
