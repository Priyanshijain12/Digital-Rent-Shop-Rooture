import { useEffect, useState } from "react";

const ProfilePage = () => {
  const [profile, setProfile] = useState<any>({});
  useEffect(() => {
    fetch('/api/users/profile/john')
      .then(res => res.json())
      .then(setProfile);
  }, []);
  return <div>{JSON.stringify(profile)}</div>;
};