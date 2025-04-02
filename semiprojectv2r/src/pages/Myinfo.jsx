import React, {useEffect, useState} from "react";

// Myinfo 함수 컴포넌트 정의
// JWT 토큰을 인증 헤더에 포함시켜
// http://localhost:8080/api/member/myinfo에 요청



const Myinfo = () => {

    const [userInfo, setUserInfo] = useState({});
    const [loading, setLoading] = useState(true);
    const fetchURL= 'http://localhost:8080/api/member/myinfo';


    useEffect(() => {
        const token = localStorage.getItem('accessToken');
        const headers = {};

        headers['Content-Type'] = `application/json`;
        headers['Accept'] = `application/json`;
        // 토큰이 존재하면 은증 헤더에 토큰을 설정하고
        if(token != null) headers['Authorization'] = `Bearer ${token}`;
        // 토큰이 없으면 로그인 페이지로 이동
        else location.href="/member/login";

        fetch(fetchURL, {
            headers: headers
        }).then(res => res.json())
            .then(data => {
                console.log(data);
                setUserInfo(data);
                setLoading(false);
            })
            .catch(err => {
                console.log('오류발생!! ', err);
                location.href="/member/login";
            });
    }, []);

    // 조건부 렌더링
    if(loading){
        return (
            <></>
        );
    }

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
                        <td><span>{userInfo.loginUser}</span></td>
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
