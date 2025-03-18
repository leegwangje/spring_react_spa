import React, { useState } from "react";

const Myinfo = () => {


    return (
        <main id="content">
            <h2>회원정보</h2>
            <div id="myinfo">
                <table className="table table-bordered mb-0">
                    {/* 테이블의 컬럼 너비, 스타일 지정 */}
                    <colgroup>
                        <col style={{ width: "30%" }} />
                        <col />
                    </colgroup>
                    <tbody>
                    <tr>
                        <td>아이디</td>
                        <td><span>abc123</span></td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td><span>abc123</span></td>
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td><span>abc123@naver.com</span></td>
                    </tr>
                    <tr>
                        <td>가입일</td>
                        <td><span>2025-03-18 12:35:35</span></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </main>
    );
}

export default Myinfo;
