'use client';
import Link from 'next/link';
interface SidebarItemProps {
  url: string;
  text: string;
  icone: any;
}
export const SidebarItem: React.FC<SidebarItemProps> = ({
  url,
  text,
  icone
}: SidebarItemProps) => {
  return (
    <>
      <li className='hover:bg-gray-100'>
        <Link
          className='flex flex-col justify-center items-center w-20 h-20'
          href={url}
        >
          {icone}
          <span className='text-xs font-light text-gray-600'>{text}</span>
        </Link>
      </li>
    </>
  );
};
